package com.poly.gestioncatalogue5gr1.controlleur;

import com.poly.gestioncatalogue5gr1.entities.Categorie;
import com.poly.gestioncatalogue5gr1.service.IServiceCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class CategorieControlleur {
    private IServiceCategory serviceCategory;

    @GetMapping("/index2")
    public String getAllCategories(Model m){
        List<Categorie> liste = serviceCategory.getAllCategories();
        m.addAttribute("categories",liste);
        return "vuecat";
    }
}
