package org.example.bdccensetspringmvc.repsoitory;

import org.example.bdccensetspringmvc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long > {
}

//JpaRepository vient de Spring Data JPA.
//
//Il fournit automatiquement :
//
//méthode	rôle
//save()	ajouter produit
//findAll()	afficher produits
//findById()	chercher produit
//deleteById()	supprimer
//
//Donc tu n’écris pas SQL.
//
//Exemple :
//
//productRepository.save(product)
//
//Spring génère automatiquement la requête SQL.