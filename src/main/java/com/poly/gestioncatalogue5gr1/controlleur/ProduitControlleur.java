package com.poly.gestioncatalogue5gr1.controlleur;

import com.poly.gestioncatalogue5gr1.entities.Categorie;
import com.poly.gestioncatalogue5gr1.entities.Produit;
import com.poly.gestioncatalogue5gr1.service.IServiceCategory;
import com.poly.gestioncatalogue5gr1.service.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProduitControlleur {
    private IServiceProduit serviceProduit;
    private IServiceCategory serviceCategory;

    @GetMapping("/index")
    public String getAllProducts(Model m , @RequestParam(name = "mc",defaultValue = "") String mc){
         List<Produit> liste = serviceProduit.getProductsByMC(mc);
         m.addAttribute("produits",liste);
        return "vue";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        serviceProduit.deleteProduct(id);
        return "redirect:/index";
    }
    @GetMapping("/formproduit")
    public String formAjout(Model m){


        m.addAttribute("categories",serviceCategory.getAllCategories());
        m.addAttribute("produit",new Produit());
        return "ajoutProd";
    }

    @GetMapping("/save")
    public String saveProduct(@ModelAttribute Produit p,Model m)
    {
        serviceProduit.saveProduct(p);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id , Model m){
        m.addAttribute("produit", serviceProduit.getProduct(id));
        m.addAttribute("categories" , serviceCategory.getAllCategories());
        return "ajoutProd";

    }
}
