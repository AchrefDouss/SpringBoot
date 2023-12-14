package com.poly.gestioncatalogue5gr1.restcontroller;

import com.poly.gestioncatalogue5gr1.entities.Produit;
import com.poly.gestioncatalogue5gr1.service.IServiceCategory;
import com.poly.gestioncatalogue5gr1.service.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor

public class ProduitRestController {
  private   IServiceProduit serviceProduit;
    private IServiceCategory serviceCategory;
    @GetMapping("/all")
    public List<Produit> getAllProducts(@RequestParam(name = "page",defaultValue = "1") int page,
                                        @RequestParam(name="size",defaultValue = "5")int size
            , @RequestParam(name = "mc",defaultValue = "")String mc){
        Page<Produit> listePage = serviceProduit.getProductsByMC(mc, PageRequest.of(page-1,size));

        return listePage.getContent();
    }


}
