package uqam.mgl7460.projet3.dsl.recettes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DslTest {
	 
	Recette recette = null ;
	String attendu = null;
	
	//construction explicite de l objet
	@Before
	public void setUp() {
		Ingredient ing1 = new Ingredient("oignons", 4) ; 
		Ingredient ing2 = new Ingredient("bouillon de poulet",3, "tasse") ;
		Ingredient ing3 = new Ingredient("beurre", 4, "cuillere a soupe") ;
		Ingredient[] tableauIngredients = {ing1,ing2, ing3 };
		
		Etape etape1 = new Etape("Peler les oignons") ;
		Etape etape2 = new Etape("Faire sauter les oignons dans le beurre") ;
		Etape etape3 = new Etape("Ajouter le bouillon du poulet");
		Etape etape4 = new Etape("Faire mijoter 30 minutes") ;
		Etape[] tableauEtapes = {etape1, etape2, etape3, etape4 } ;
		
		recette = new Recette ( "Soupe a l'oignon",
								4, "personne",
								"00:45", "minute",
								tableauIngredients,
								tableauEtapes) ;
		
		attendu = recette.toString() ;
	}
	
	//produit la meme chaine que l objet construit explicitement
	@Test
	public void creerRecetteAvecDslTest() {
		Recette recetteDsl = new Recette ( rec -> {
    		rec.titre("Soupe a l'oignon");
    		rec.quantite(4);
			rec.unite_quantite("personne");
    		rec.temps_preparation("00:45");
			rec.unite_temps("minute");
    		rec.ingredients("oignons", 4);
    		rec.ingredients("bouillon de poulet",3, "tasse");
    		rec.ingredients("beurre", 4, "cuillere a soupe"); 
    		rec.etapes_recette(new Etape("Peler les oignons"),
    				new Etape("Faire sauter les oignons dans le beurre"),
    				new Etape("Ajouter le bouillon du poulet"),
    				new Etape("Faire mijoter 30 minutes")
    				) ;
    	}) ;
			
		assertEquals(attendu, recetteDsl.toString()) ;
	}
	
	//produit la meme chaine meme si on inversel ordre d appels des methodes
	@Test
	public void creerRecetteAvecDslSansOrdreTest() {
		Recette recetteDsl = new Recette ( rec -> {
    		rec.titre("Soupe a l'oignon");
    		rec.ingredients("oignons", 4);
			rec.ingredients("bouillon de poulet",3, "tasse");
			rec.ingredients("beurre", 4, "cuillere a soupe"); 
    		rec.temps_preparation("00:45");
    		rec.quantite(4);
			rec.unite_quantite("personne");
			rec.unite_temps("minute");
    		rec.etapes_recette(new Etape("Peler les oignons"),
    				new Etape("Faire sauter les oignons dans le beurre"),
    				new Etape("Ajouter le bouillon du poulet"),
    				new Etape("Faire mijoter 30 minutes")
    				) ;
    	}) ;
		
		assertEquals(recetteDsl.toString(), attendu) ;
	}
}
