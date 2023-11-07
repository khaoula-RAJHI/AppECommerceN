package com.stage.eCommerce.services;

import com.stage.eCommerce.entities.Commande;
import com.stage.eCommerce.entities.Produit;

import java.util.List;

public interface ICommandeService {

    List<Commande> retrieveAllCommandes();

    Commande addCommande(Commande c);

    void deleteCommande(Long id);

    Commande updateCommande(Commande c);

    double calculateMontant(Commande c);
}
