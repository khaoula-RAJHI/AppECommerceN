package com.stage.eCommerce.controllers;

import java.util.List;

import com.stage.eCommerce.entities.CategorieProduit;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.stage.eCommerce.entities.Produit;
import com.stage.eCommerce.services.IProduitService;

import io.swagger.annotations.Api;


@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	IProduitService produitService;

	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		List<Produit> list = produitService.retrieveAllProduits();
		return list;
	}

	// http://localhost:8089/SpringMVC/produit/retrieve-produit/8
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}

	/* Ajouter en produit tout en lui affectant la catégorie produit et le stock associés */
	// http://localhost:8089/SpringMVC/produit/add-produit/{idCategorieProduit}/{idStock}
	@PostMapping("/add-produit")
	@ResponseBody
	public Produit addProduit(@RequestBody Produit p) {
		Produit produit = produitService.addProduit(p);
		return produit;
	}

	// http://localhost:8089/SpringMVC/produit/remove-produit/{produit-id}
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	// http://localhost:8089/SpringMVC/produit/modify-produit/{idCategorieProduit}/{idStock}
	@PutMapping("/modify-produit")
	@ResponseBody
	public Produit modifyProduit(@RequestBody Produit p) {
		return produitService.updateProduit(p);
	}

	@PostMapping("/addAndAssignProduitToCategorie/{idCategorieProduit}")
	@ResponseBody
	public Produit addAndAssignProduitToCategorie(@RequestBody Produit p , @PathVariable Long idCategorieProduit ) {
		Produit produit = produitService.addAndAssignProduitToCategorie(p, idCategorieProduit);
		return produit;

	}


	@ApiOperation(value = "Récuperer la liste des produits par categorie")
	@GetMapping("/getproduitparCategorie/{idCategorieProduit}")
	@ResponseBody
	public List<Produit> getproduitparCategorie(@PathVariable("idCategorieProduit") Long idCategorieProduit){
		return produitService.getproduitparCategorie(idCategorieProduit);
	}



	/*
	 * Revenu Brut d'un produit (qte * prix unitaire de toutes les lignes du
	 * detailFacture du produit envoyé en paramètre )
	 */
	// http://localhost:8089/SpringMVC/produit/getRevenuBrutProduit/1/{startDate}/{endDate}
/*	@GetMapping(value = "/getRevenuBrutProduit/{idProduit}/{startDate}/{endDate}")
	public float getRevenuBrutProduit(@PathVariable("idProduit") Long idProduit,
			@PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {

		return produitService.getRevenuBrutProduit(idProduit, startDate, endDate);
	}*/

}
