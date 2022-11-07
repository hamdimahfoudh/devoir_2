package com.example.produit;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.produit.entities.Categorie;
import com.example.produit.entities.Produit;
import com.example.produit.repos.ProduitRepository;

@SpringBootTest
class Produits1ApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	@Test
	public void testCreateProduit() {
	Produit prod = new Produit("Samsung S20 ultra",2200.500,new Date());
	produitRepository.save(prod);
	}
	
	@Test
	public void testFindProduit() {
	Produit p = produitRepository.findById(1L).get() ; 
	//produitRepository.save(p);
	System.out.println(p);
	}
	
	@Test
	public void testUpdateProduit()
	{
	Produit p = produitRepository.findById(1L/*(long)3*/).get();
	p.setPrixProduit(1050.0);
	produitRepository.save(p);
	}
	
	@Test
	public void testDeleteProduit()
	{
	produitRepository.deleteById(6L);
	}
	 
	@Test
	public void testListerTousProduits()
	{
	List<Produit> prods = produitRepository.findAll();
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testFindProduitByNom() {
	List<Produit> prods = produitRepository.findByNomProduit("PC Samsung") ;
	for(Produit p:prods)
	  System.out.println(p);
	}
	
	@Test
	public void testFindProduitByNomContains() {
	List<Produit> prods = produitRepository.findByNomProduitContains("P") ;
	for(Produit p:prods)
	  System.out.println(p);
	}
	
	@Test
	public void testfindByNomPrix()
	{
	List<Produit> prods = produitRepository.findByNomPrix("PC Asus", 1070.0);
	    for (Produit p : prods)
	   {
	      System.out.println(p);
	   }
	}
	
	
	@Test
	public void testfindByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(1L);
	List<Produit> prods = produitRepository.findByCategorie(cat);
	for (Produit p : prods)
	{
	  System.out.println(p);
	}
	}
	
	@Test
	public void findByCategorieIdCat()
	{
	List<Produit> prods = produitRepository.findByCategorieIdCat(2L);
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	 }

	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Produit> prods = produitRepository.trierProduitsNomsPrix();
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}


	
}              
