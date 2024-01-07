package com.stage.eCommerce.repositories;

import com.stage.eCommerce.entities.CategorieProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.stage.eCommerce.entities.Produit;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {


    //afficher PRODUITS By CATEGORIE
    @Query("SELECT p from Produit p where p.categorieProduit.idCategorieProduit=:idCategorieProduit")
    List<Produit> getproduitparCategorie(@Param("idCategorieProduit") Long idCategorieProduit);

    //afficher PRODUITS By COMMANDE
    //@Query("SELECT p from Produit p where p.commande.idCommande=:idCommande")
    //List<Produit> findByCommandeId(@Param("idCommande") Long idCommande);


	
	
	
	
	
	
	
	
	
	
	
	/*@Query("SELECT sum(df.prixTotal) FROM DetailFacture df where df.produit=:produit and df.facture.dateFacture between :startDate"
			+ " and :endDate and df.facture.active=true")
	public float getRevenuBrutProduit(@Param("produit") Produit produit, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate);*/
}
