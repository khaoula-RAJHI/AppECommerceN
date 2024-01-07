package com.stage.eCommerce.services;

import java.util.List;

import com.stage.eCommerce.entities.CategorieProduit;
import com.stage.eCommerce.entities.Produit;
import com.stage.eCommerce.entities.Role;

public interface IProduitService {

	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p);

	void deleteProduit(Long id);

	Produit updateProduit(Produit p);

	Produit retrieveProduit(Long id);

	Produit addAndAssignProduitToCategorie(Produit p, Long idCategorieProduit);

	List<Produit> getproduitparCategorie(Long idCategorieProduit);
	List<CategorieProduit> displayCategories();
}
