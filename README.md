# Système de Gestion de Produits - Architecture Full Stack (Angular + Spring Boot)
 
Le backend est développé avec **Spring Boot**, et le frontend avec **Angular**.

---

##  Objectif du projet

L’application permet de :
- Afficher la liste des produits
- supprimer des produits

---

##  Technologies utilisées

### Backend (Spring Boot)
- Java 17+
- Spring Boot 3
- Spring Data JPA
- Spring Security
- REST API
- H2 Database / MySQL
- Maven

### Frontend (Angular)
- Angular 17+
- TypeScript
- HttpClient (withFetch)
- Standalone Components
- Bootstrap CSS 
- Lucide Icons

---

##  Architecture du projet

### 🔙 Backend (Spring Boot)
Le backend suit une architecture en couches :

- **Entity** : `Product` (modèle de données)
- **Repository** : `ProductRepository` (CRUD avec Spring Data JPA)
- **Controller** : API REST pour exposer les endpoints
- **Security** : `SecurityConfig` pour gérer les accès

📌 Exemple de configuration de sécurité :
- `/public/**` → accès libre
- Autres routes → authentification requise

---

###  Frontend (Angular)

Le frontend est organisé en composants :

- **HomeComponent** : page d’accueil
- **ProductsComponent** : affichage des produits
- **Services** : `ProductService` pour communiquer avec le backend

Fonctionnalités principales :
- Affichage des produits sous forme de tableau
- Suppression d’un produit
- Communication avec API REST via HttpClient

---

## Communication Frontend / Backend

Le frontend consomme l’API Spring Boot via HTTP :

- GET → récupérer les produits
- POST → ajouter un produit
- DELETE → supprimer un produit

Configuration Angular :
```ts
provideHttpClient(withFetch())
