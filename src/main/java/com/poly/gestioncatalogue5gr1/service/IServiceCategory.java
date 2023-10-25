package com.poly.gestioncatalogue5gr1.service;

import com.poly.gestioncatalogue5gr1.entities.Categorie;


import java.util.List;

public interface IServiceCategory {
    public void saveCategory(Categorie c);
    public List<Categorie> getAllCategories();
    public List<Categorie> getCategoriesByMC(String mc);
    public void deleteCategorie(Long id);
    public Categorie getCategorie(Long id);
}
