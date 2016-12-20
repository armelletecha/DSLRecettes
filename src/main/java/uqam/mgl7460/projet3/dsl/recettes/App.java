package uqam.mgl7460.projet3.dsl.recettes;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args ) {
    	
    	ArrayList<Ingredient> listeIngredients = new ArrayList<Ingredient>() ;
    	listeIngredients.add(new Ingredient("oignons", 4)) ;
    	listeIngredients.add(new Ingredient("bouillon de poulet", 3, Unite.Tasses)) ;
    	listeIngredients.add(new Ingredient("beurre", 4, Unite.cuillere_a_soupe)) ;
    	
    	ArrayList<Etape> listeEtapes = new ArrayList<Etape>() ;
    	listeEtapes.add(new Etape("Peler les oignons")) ;
    	listeEtapes.add(new Etape("Faire sauter les oignons dans le beurre")) ;
    	listeEtapes.add(new Etape("Ajouter le bouillon de poulet")) ;
    	listeEtapes.add(new Etape("Faire mijoter 30 minutes")) ;
    	
    	Recette recette = new Recette ( rec -> {
    		rec.setTitre("Soupe a l'oignon");
    		rec.setQuantite(4);
    		rec.setUniteQuantite(Unite.Portions);
    		rec.setTempsPreparation("1:45");
    		rec.setUniteTemps(Unite.Heures+":"+Unite.Minutes);
    		rec.setIngredients(listeIngredients) ;
    		rec.setEtapes(listeEtapes) ;    		
    	}) ;
    System.out.println(recette);	
    }
}
