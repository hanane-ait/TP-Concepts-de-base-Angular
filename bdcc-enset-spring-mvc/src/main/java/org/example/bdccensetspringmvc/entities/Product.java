package org.example.bdccensetspringmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity //Indique à Hibernate que cette classe représente une table dans la base de données.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder //permet de créer un objet
public class Product {
    @Id //clé primaire
    @GeneratedValue //la base de données génère automatiquement l'id.
    private long id;
    @NotEmpty
    @Size(min = 3, max = 50 )
    private String name;
    @Min(0)
    private double price;
    @Min(1 )
    private double quantity;


}
