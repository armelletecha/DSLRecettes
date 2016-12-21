package uqam.mgl7460.projet3.dsl.recettes;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecetteTest {
	 
	Recette recette = null ;
	
	//retourne vrai si tous les elements de la recette sont remplis, aucun champ n est vide
	@Test
	public void creerRecetteCompleteTest() {
		recette = new Recette ( rec -> {
    		rec.titre("Soupe a l'oignon");
    		rec.quantite(4);
			rec.unite_quantite("personne");
    		rec.temps_preparation("00:45");
			rec.unite_temps("minute");
    		rec.ingredients("oignons", 4) ;  
    		rec.etapes("Peler les oignons") ;
    	}) ;
			
		assertEquals(recette.complete(), true) ;
	}
	
	//retourne la recette complete avec tous les champs remplis
	@Test
	public void retournerRecetteCompleteTest() {
		recette = new Recette ( rec -> {
    		rec.titre("Soupe a l'oignon");
    		rec.quantite(4);
			rec.unite_quantite("personne");
    		rec.temps_preparation("00:45");
			rec.unite_temps("minute");
    		rec.ingredients("oignons", 4);
    		rec.ingredients("bouillon de poulet",3, "tasse");
    		rec.ingredients("beurre", 4, "cuillere a soupe");  
    		rec.etapes("Peler les oignons",
								"Faire sauter les oignons dans le beurre",
    							"Ajouter le bouillon du poulet",
    							"Faire mijoter 30 minutes");
    	}) ;
		String resultatAttendu = "Soupe a l'oignon\n" +
								"pour 4 personnes\n" +
								"Temps de preparation: 45 minutes\n \n" +
								"Ingredients \n" +
								"4 oignons\n" +
								"3 tasses de bouillon de poulet\n" +
								"4 cuilleres a soupe  de beurre\n\n" +
								"Preparation \n" +
								"1. Peler les oignons\n" +
								"2. Faire sauter les oignons dans le beurre\n" +
								"3. Ajouter le bouillon du poulet\n" +
								"4. Faire mijoter 30 minutes\n";
		assertEquals(recette.toString(), resultatAttendu) ;
	}
	
	//creer une recette incomplete 
	@Test
	public void creerRecetteIncompleteNonQuantiteTest() {
		recette = new Recette ( rec -> {
    		rec.titre("Soupe a l'oignon");
    		rec.quantite(0);
			rec.unite_quantite(null);
    		rec.temps_preparation("00:45");
			rec.unite_temps("minute");
    		rec.ingredients("oignons", 4) ;  
    		rec.etapes("Peler les oignons") ;
    	}) ;

		assertEquals(recette.complete(), false) ;
	}
		
	@Test
	public void creerRecetteIncompleteNonIngredientTest() {
		recette = new Recette ( rec -> {
    		rec.titre("Soupe a l'oignon");
    		rec.quantite(4);
			rec.unite_quantite("portion");
    		rec.temps_preparation("00:45");
			rec.unite_temps("minute");
    		rec.ingredients() ;  
    		rec.etapes("Peler les oignons") ;
    	}) ;
		assertEquals(recette.complete(), false) ;
	}
	
	@Test
	public void creerRecetteIncompleteNonEtapeTest() {
		recette = new Recette ( rec -> {
    		rec.titre("Soupe a l'oignon");
    		rec.quantite(4);
			rec.unite_quantite("portion");
    		rec.temps_preparation("00:45");
			rec.unite_temps("minute");
    		rec.ingredients("oignons", 4) ;  
    		rec.etapes() ;
    	}) ;

		assertEquals(recette.complete(), false) ;
	}
}
