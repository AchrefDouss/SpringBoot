package com.poly.gestioncatalogue5gr1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 1, max = 20)
    private String nom;
    @Min(1)
    private double prix;
    @Min(1)
    private int quantite;
    @ManyToOne
    @NotNull(message = "La categorie ne doit pas être vide")
    private Categorie categorie;
    private String photo;
}
