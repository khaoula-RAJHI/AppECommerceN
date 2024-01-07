package com.stage.eCommerce.services;

import com.stage.eCommerce.entities.Commande;
import com.stage.eCommerce.entities.Produit;
import com.stage.eCommerce.entities.User;

import java.util.List;

public interface ICommandeService {

    List<Commande> retrieveAllCommandes();

    Commande saveCommande(Commande commande);

    Commande retrieveCommande(Long id);

    double calculerMontantCommande(Commande commande);

    List<Produit> displayProducts();
    List<User> displayUsers();

    void deleteCommande(Long id);

    Commande addcmd(Commande c, Long productId);




}
