package com.BasmaOnlineStoreProduct;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.BasmaOnlineStoreProduct.beans.Categorie;
import com.BasmaOnlineStoreProduct.beans.Produit;
import com.BasmaOnlineStoreProduct.repository.CategorieRepository;
import com.BasmaOnlineStoreProduct.repository.ProduitRepository;
 

@SpringBootTest
class BasmaOnlineStoreProductApplicationTests {

	@Autowired
    private CategorieRepository categoryRepository;
	@Autowired
    private ProduitRepository produitRepo;
	@Test
	void contextLoads() {
	}
	
	@Test
	 void saveALL() {
		ArrayList<String> listImage = new ArrayList<String>();
		listImage.add("img1");
		listImage.add("img2");
		listImage.add("img3");
		listImage.add("img4");
		Categorie category = categoryRepository.save(new Categorie( "Cosmetiquos", "img", new ArrayList<Produit>()));
		produitRepo.save(new Produit(null, "Sunglasses", Math.random()*100, 20, listImage, category));
        assertThat(produitRepo.findByName("Sunglasses")).isNotNull();
    }
	
	@Test
	void allCategories()
	{
		 
		 List<Categorie> listCategory = categoryRepository.findAll();
        assertThat(0).isNotEqualTo(listCategory.size());
		
	}
	
	@Test
	void allProducts()
	{
		 
		 List<Produit> listProduit = produitRepo.findAll();
        assertThat(0).isNotEqualTo(listProduit.size());
		
	}

}
