package com.stage.eCommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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

    private String nomClient;
    @Temporal(TemporalType.DATE)
    private Date dateCommande;
    private double montant;

    @ManyToOne
    @JsonIgnore
    private User users;

    @OneToMany(mappedBy = "commande")
    @JsonIgnore
    private Set<Produit> products;


}

