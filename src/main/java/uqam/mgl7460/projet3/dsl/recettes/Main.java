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
    		rec.etapes_recette(new Etape("Peler les oignons"),
    				new Etape("Faire sauter les oignons dans le beurre"),
    				new Etape("Ajouter le bouillon du poulet"),
    				new Etape("Faire mijoter 30 minutes")
    				) ;
    	}) ;
    	
   System.out.println(recette);	
    }
}
