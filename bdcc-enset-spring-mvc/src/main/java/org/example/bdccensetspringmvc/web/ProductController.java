package org.example.bdccensetspringmvc.web;


import jakarta.validation.Valid;
import org.example.bdccensetspringmvc.entities.Product;
import org.example.bdccensetspringmvc.repsoitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired  //injection des dependancs meilleru que ca ces constructeur par parammetr
    private ProductRepository productRepository;
    @GetMapping("/user/index") //pour acceder a cette methode
    public String index(Model model){ //etourn page appele products
        List<Product> products = productRepository.findAll();
        model.addAttribute("productList",products);
        return "products";
    }

    @GetMapping("/")
    public String Home(){
        return "redirect:/user/index";
    }
@GetMapping("/admin/delete")
    public String delete(@RequestParam(name = "id") Long id){
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }
    @GetMapping("/admin/newProduct")
    public String newProduct(Model  model){
        model.addAttribute("product", new Product());
        return "newProduct";

    }
    @PostMapping("/admin/saveProduct")
    //@Valid il sassure qu les champ correspond au contrainte les msg d erreu stocke dans une collection bindingResult lors de validation il prend les donnes saisie et il le stocke dans le model en utilisant u attribut qui porte mem nom que cette variable
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) return "newProduct";
        productRepository.save(product);
        return "redirect:/admin/newProduct";
    }

    @GetMapping("/notAuthorized")
    public String notAuthorized(){
          return "notAuthorized";
    }
}

