package com.poly.gestioncatalogue5gr1.controlleur;

import com.poly.gestioncatalogue5gr1.entities.Categorie;
import com.poly.gestioncatalogue5gr1.entities.Produit;
import com.poly.gestioncatalogue5gr1.service.IServiceCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class CategorieControlleur {
    private IServiceCategory serviceCategory;

    @GetMapping("/user/index2")
    public String getAllCategories(Model m, @RequestParam(name="mc",defaultValue = "") String mc){
        List<Categorie> liste = serviceCategory.getCategoriesByMC(mc);
        m.addAttribute("categories",liste);
        return "vuecat";
    }
    @GetMapping("/admin/deleteCat/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        serviceCategory.deleteCategorie(id);
        return "redirect:/user/index2";
    }
    @GetMapping("/admin/formcategorie")
    public String formAjouter(Model m){
            m.addAttribute("categorie",new Categorie());
            return "ajoutCat";
    }

    @GetMapping("/admin/add")
    public String saveCategorie(@ModelAttribute Categorie c, Model m)
    {
        serviceCategory.saveCategory(c);
        return "redirect:/user/index2";
    }

    @GetMapping("/admin/editcat/{id}")
    public String editCategorie(@PathVariable("id") Long id,Model m){

        m.addAttribute("categorie",serviceCategory.getCategorie(id));

        return "ajoutCat";
    }

}
