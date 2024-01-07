package com.stage.eCommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commande {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;

    private int quantite;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user")
    private User users;
/*
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "produit")
    private Produit product;
*/

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "commandes_produits",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id"))
    private Set<Produit> product = new HashSet<>();

}

