package com.poly.gestioncatalogue5gr1.restcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.gestioncatalogue5gr1.entities.Produit;
import com.poly.gestioncatalogue5gr1.service.IServiceCategory;
import com.poly.gestioncatalogue5gr1.service.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/produit")
public class ProduitRestController {
  private   IServiceProduit serviceProduit;
    private IServiceCategory serviceCategory;
    @GetMapping
    public List<Produit> getAllProducts(@RequestParam(name = "page",defaultValue = "1") int page,
                                        @RequestParam(name="size",defaultValue = "5")int size
            , @RequestParam(name = "mc",defaultValue = "")String mc){
        Page<Produit> listePage = serviceProduit.getProductsByMC(mc, PageRequest.of(page-1,size));

        return listePage.getContent();
    }

    @DeleteMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProd(@PathVariable("id") Long id){
        serviceProduit.deleteProduct(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addproduct(@RequestParam("produit")String produit, @RequestParam("file")MultipartFile mf) throws IOException {
        Produit p = new ObjectMapper().readValue(produit,Produit.class);
        serviceProduit.saveProduct(p,mf);


    }

}
