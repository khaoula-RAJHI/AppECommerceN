package com.stage.eCommerce.controllers;

import com.stage.eCommerce.entities.Commande;
import com.stage.eCommerce.entities.Produit;
import com.stage.eCommerce.entities.User;
import com.stage.eCommerce.services.ICommandeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des commandes")
@RequestMapping("/commande")

public class CommandeRestController {
    @Autowired
    ICommandeService commandeService;


    @GetMapping("/retrieve-all-commandes")
    @ResponseBody
    public List<Commande> getCommandes() {
        List<Commande> list = commandeService.retrieveAllCommandes();
        return list;
    }

    @PostMapping("/commandes")
    public void saveCommande(@RequestBody Commande commande) {
        commandeService.saveCommande(commande);
    }

    @GetMapping("/commandes/{commandeId}/montant")
    public double calculerMontantCommande(@PathVariable Long commandeId) {
        Commande commande = commandeService.retrieveCommande(commandeId);
        return commandeService.calculerMontantCommande(commande);
    }

    @GetMapping("/displayProducts")
    @ResponseBody
    public  List<Produit> displayProducts() {
        List<Produit> list = commandeService.displayProducts();
        return list;
    }
    @GetMapping("/displayUsers")
    @ResponseBody
    public  List<User> displayUsers() {
        List<User> list = commandeService.displayUsers();
        return list;
    }

    /*
    @PostMapping("/add-commande")
    @ResponseBody
    public Commande addCommande(@RequestBody Commande c) {
        Commande commande = commandeService.addCommande(c);
        return commande;
    }
    */

    @DeleteMapping("/remove-commande/{commande-id}")
    @ResponseBody
    public void removeCommande(@PathVariable("commande-id") Long CommandeId) {
        commandeService.deleteCommande(CommandeId);
    }
/*
    @PostMapping("/products/{productId}")
    @ResponseBody
    public ResponseEntity<String> addcmd(@RequestBody Commande c, @PathVariable Long productId) {
        if () {
            return ResponseEntity.ok("ajout réussi");
        } else {
            return ResponseEntity.notFound().build(); // ou une réponse appropriée en cas d'échec de la mise à jour
        }
    }
*/
/*
    @PutMapping("/modify-commande")
    @ResponseBody
    public Commande modifyCommande(@RequestBody Commande c) {

        return commandeService.updateCommande(c);
    }

    @PostMapping("/commandes/total")
    public double calculateMontant(@RequestBody Commande c) {
        return commandeService.calculateMontant(c);
    }
*/
}
