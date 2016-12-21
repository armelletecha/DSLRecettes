package uqam.mgl7460.projet3.dsl.recettes;

public class Main 
{
    public static void main( String[] args ) throws InstantiationException, IllegalAccessException {

    	Recette recette = new Recette ( rec -> {
    		rec.titre("Soupe a l'oignon");
    		rec.quantite(4);
			rec.unite_quantite("personne");
    		rec.temps_preparation("00:45");
			rec.unite_temps("minute");
    		rec.ingredients("oignons", 4);
    		rec.ingredients("bouillon de poulet",3, "tasse");
    		rec.ingredients("beurre", 4, "cuillere a soupe") ;  
    		rec.etapes("Peler les oignons",
    							"Faire sauter les oignons dans le beurre",
    							"Ajouter le bouillon du poulet",
    							"Ajouter le beurre");
    	}) ;
    	
   System.out.println(recette);	
    }
}
