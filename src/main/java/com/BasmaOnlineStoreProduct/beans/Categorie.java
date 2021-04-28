package com.BasmaOnlineStoreProduct.beans;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categorie {
	public Categorie(String string, String string2, ArrayList<Produit> arrayList) {
	 
		setName(string);
		setImage(string2);
		 this.produits=arrayList;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull@Column(unique=true)
    private String name;
	@NotNull
	private String image;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorie", cascade = CascadeType.ALL)
	private Collection<Produit> produits;
}
