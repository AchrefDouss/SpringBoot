package com.poly.gestioncatalogue5gr1.controlleur;

import com.poly.gestioncatalogue5gr1.entities.Produit;
import com.poly.gestioncatalogue5gr1.service.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProduitControlleur {
    private IServiceProduit serviceProduit;

    @GetMapping("/index")
    public String getAllProducts(Model m){
         List<Produit> liste = serviceProduit.getAllProducts();
         m.addAttribute("produits",liste);
        return "vue";
    }
}
