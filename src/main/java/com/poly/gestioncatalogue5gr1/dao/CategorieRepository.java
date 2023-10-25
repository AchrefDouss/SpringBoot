package com.poly.gestioncatalogue5gr1.dao;

import com.poly.gestioncatalogue5gr1.entities.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    public List<Categorie> findByNomContains(String mc);
}
