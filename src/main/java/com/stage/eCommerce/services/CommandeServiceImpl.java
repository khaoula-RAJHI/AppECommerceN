package com.stage.eCommerce.services;


import com.stage.eCommerce.entities.Commande;
import com.stage.eCommerce.entities.Produit;
import com.stage.eCommerce.entities.User;
import com.stage.eCommerce.repositories.CommandeRepository;
import com.stage.eCommerce.repositories.ProduitRepository;
import com.stage.eCommerce.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            log.info(" Commande : " + commandes);
        }
        return commandes;
    }

    @Override
    public Commande addCommande(Commande c) {
        double montant = calculateMontant(c);
        c.setMontant(montant);
        return commandeRepository.save(c);
    }

    @Override
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public Commande updateCommande(Commande c) {
        if (commandeRepository.existsById(c.getIdCommande())) {
            double montant = calculateMontant(c);
            c.setMontant(montant);
            return commandeRepository.save(c);
        } else {
            // Gérer le cas où la commande n'existe pas, peut-être lancer une exception, etc.
            return null;
        }
    }

    @Override
    public double calculateMontant(Commande c) {
        // Implémentez la logique pour calculer le montant en fonction des attributs de la commande, de l'utilisateur et des produits
        User user = c.getUsers();
        List<Produit> produits = produitRepository.findByCommandeId(c.getIdCommande());

        double totalMontant = 0.0;

        // Logique de calcul du montant en fonction des produits
        for (Produit produit : produits) {
            totalMontant += produit.getPrix();
        }

        // Ajoutez d'autres calculs basés sur l'utilisateur, par exemple des réductions, des taxes, etc.

        return totalMontant;
    }
    }
/*
    @Override
    public Commande calculerTotal(Commande commande) {
        Set<Produit> products = commande.getProducts();
        double total = 0;

        for (Produit product : products) {
            total += product.getPrix() * product.getQuantite();
        }

        commande.setMontant(total);
        return commande;
    }*/

