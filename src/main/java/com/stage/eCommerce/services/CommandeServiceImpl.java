package com.stage.eCommerce.services;


import com.stage.eCommerce.entities.Commande;
import com.stage.eCommerce.entities.Produit;
import com.stage.eCommerce.entities.Role;
import com.stage.eCommerce.entities.User;
import com.stage.eCommerce.repositories.CommandeRepository;
import com.stage.eCommerce.repositories.ProduitRepository;
import com.stage.eCommerce.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommandeServiceImpl implements ICommandeService {
    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Commande> retrieveAllCommandes() {
        List<Commande> commandes = (List<Commande>) commandeRepository.findAll();
        for (Commande commande : commandes) {
            log.info(" Commande : " + commande);
        }
        return commandes;
    }

    public Commande retrieveCommande(Long commandeId){
        Commande commande = commandeRepository.findById(commandeId).orElse(null);
        log.info("commande :" + commande);
        return commande;

    }
    @Override
    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }
    @Override
    public double calculerMontantCommande(Commande commande) {
        double montant = 0.0;

        // Itérer sur les produits associés à la commande et accumuler le prix
        for (Produit produit : commande.getProduct()) {
            montant += produit.getPrix();
        }

        // Multipliez par la quantité pour obtenir le montant total
        montant *= commande.getQuantite();

        return montant;
    }

    @Override
    public List<Produit> displayProducts() {
        return produitRepository.findAll();
    }
    @Override
    public List<User> displayUsers() {
        return userRepository.findAll();
    }
/*
    @Override
    public Commande addCommande(Commande c) {
        double montant = calculateMontant(c);
        c.setMontant(montant);
        return commandeRepository.save(c);
    }
*/
    @Override
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }


    public Commande addcmd(Commande c, Long productId) {
        Optional<Produit> produitOptional = produitRepository.findById(productId);

        if (produitOptional.isPresent()) {
            Produit produit = produitOptional.get();
            c.getProduct().clear();
            c.getProduct().add(produit);
            commandeRepository.save(c);
            return c;
        }
        return c;
    }
    }


