package org.example.bdccensetspringmvc.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 🔐 Encoder des mots de passe
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 👤 Utilisateurs en mémoire
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        return new InMemoryUserDetailsManager(
                User.withUsername("user1")
                        .password(passwordEncoder.encode("1234"))
                        .roles("USER")
                        .build(),

                User.withUsername("user2")
                        .password(passwordEncoder.encode("1234"))
                        .roles("USER")
                        .build(),

                User.withUsername("admin")
                        .password(passwordEncoder.encode("1234"))
                        .roles("USER", "ADMIN")
                        .build()
        );
    }

    // 🔒 Configuration sécurité
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // ❗ Désactiver CSRF (important pour Angular)
                .csrf(csrf -> csrf.disable())

                // ✅ Form login (page login Spring)
                .formLogin(Customizer.withDefaults())

                // 🔑 Autorisations
                .authorizeHttpRequests(auth -> auth
                        // ✅ autoriser Angular à accéder aux produits
                        .requestMatchers("/products/**").permitAll()

                        // 🔐 routes protégées
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // 🌍 public
                        .requestMatchers("/public/**").permitAll()

                        // 🔒 tout le reste nécessite login
                        .anyRequest().authenticated()
                )

                // 🚫 accès refusé
                .exceptionHandling(eh -> eh
                        .accessDeniedPage("/notAuthorized")
                )

                .build();
    }
}