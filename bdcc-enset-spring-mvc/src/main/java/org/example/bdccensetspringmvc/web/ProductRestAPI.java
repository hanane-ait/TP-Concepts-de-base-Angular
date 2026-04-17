package org.example.bdccensetspringmvc.web;

import org.example.bdccensetspringmvc.entities.Product;
import org.example.bdccensetspringmvc.repsoitory.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*") //autorise toute les domaines
//@CrossOrigin("http://localhost:8084") //autorise toute les pages provient de ce domaine d envoyer des requets http
public class ProductRestAPI {
    private ProductRepository productRepository;

    public ProductRestAPI(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @GetMapping("/products")
    public List<Product> listProducts(){
       return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product fingById(@PathVariable(name= "id") Long id) {
        return productRepository.findById(id).get();
    }

    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable(name= "id") Long id) {
         productRepository.deleteById(id);
    }

}
