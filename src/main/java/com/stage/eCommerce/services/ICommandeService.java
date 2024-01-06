package com.stage.eCommerce.services;

import com.stage.eCommerce.entities.Commande;
<<<<<<< Updated upstream
import com.stage.eCommerce.entities.Produit;

=======
>>>>>>> Stashed changes
import java.util.List;

public interface ICommandeService {

    List<Commande> retrieveAllCommandes();

<<<<<<< Updated upstream
    Commande addCommande(Commande c);

    void deleteCommande(Long id);

    Commande updateCommande(Commande c);

    double calculateMontant(Commande c);
=======
    Commande saveCommande(Commande commande);

    Commande retrieveCommande(Long id);

    double calculerMontantCommande(Commande commande);

    void deleteCommande(Long id);




>>>>>>> Stashed changes
}
