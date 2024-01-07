package com.stage.eCommerce.services;

import java.util.List;
import javax.transaction.Transactional;

import com.stage.eCommerce.entities.CategorieProduit;
import com.stage.eCommerce.entities.Role;
import com.stage.eCommerce.repositories.CategorieProduitRepository;
import com.stage.eCommerce.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stage.eCommerce.entities.Produit;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

	@Autowired
    ProduitRepository produitRepository;
	@Autowired
    CategorieProduitRepository categorieProduitRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		for (Produit produit : produits) {
			log.info(" Produit : " + produit);
		}
		return produits;
	}

	@Transactional
	public Produit addProduit(Produit p) {
		produitRepository.save(p);
		return p;
	}

	

	@Override
	public void deleteProduit(Long produitId) {
		produitRepository.deleteById(produitId);
	}

	@Override
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long produitId) {
		Produit produit = produitRepository.findById(produitId).orElse(null);
		log.info("produit :" + produit);
		return produit;
	}

	@Override
	public Produit addAndAssignProduitToCategorie(Produit p, Long idCategorieProduit) {
		log.info("In method addProduit");
		CategorieProduit cp = categorieProduitRepository.findById(idCategorieProduit).orElse(null);
		p.setCategorieProduit(cp);
		produitRepository.save(p);
		return p;


	}

	@Override
	public List<Produit> getproduitparCategorie(Long idCategorieProduit) {
		List<Produit> produitParCat=(List<Produit>) produitRepository.getproduitparCategorie(idCategorieProduit);
		return produitParCat ;
	}

	@Override
		public List<CategorieProduit> displayCategories() {
		return categorieProduitRepository.findAll();
	}


}