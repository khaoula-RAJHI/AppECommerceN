package com.stage.eCommerce.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prix;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categorieProduit")
	private CategorieProduit categorieProduit;
/*
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user")
	private User user;
*/


<<<<<<< Updated upstream
	@ManyToOne
	@JsonIgnore
	private Commande commande;

=======
	/*
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private Set<Commande> commande;
*/
>>>>>>> Stashed changes


	/*
	@OneToMany(mappedBy = "produit")
	@JsonIgnore
	private Set<DetailFacture> detailFacture;
	 */

	


	

}
