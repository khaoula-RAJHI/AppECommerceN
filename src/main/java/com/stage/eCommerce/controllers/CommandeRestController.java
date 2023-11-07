package com.stage.eCommerce.controllers;

import com.stage.eCommerce.entities.Commande;
import com.stage.eCommerce.services.ICommandeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/add-commande")
    @ResponseBody
    public Commande addCommande(@RequestBody Commande c) {
        Commande commande = commandeService.addCommande(c);
        return commande;
    }

    @DeleteMapping("/remove-commande/{commande-id}")
    @ResponseBody
    public void removeCommande(@PathVariable("commande-id") Long CommandeId) {
        commandeService.deleteCommande(CommandeId);
    }


    @PutMapping("/modify-commande")
    @ResponseBody
    public Commande modifyCommande(@RequestBody Commande c) {

        return commandeService.updateCommande(c);
    }

    @PostMapping("/commandes/total")
    public double calculateMontant(@RequestBody Commande c) {
        return commandeService.calculateMontant(c);
    }

}
