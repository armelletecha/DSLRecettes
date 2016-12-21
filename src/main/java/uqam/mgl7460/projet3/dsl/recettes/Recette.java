package uqam.mgl7460.projet3.dsl.recettes;

import unites.Heure;
import unites.Minute;
import unites.Personne;
import unites.Portion;
import unites.Tasse;
import unites.Unite;

public class Recette {
	private String titre;
	private int quantite;
	private String unite_quantite;
	private String[] temps_preparation;
	private String unite_temps;
	private Ingredient[] ingredients_recette;
	private Etape [] etapes_recette;
	//private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>() ;
	//private ArrayList<Etape> etapes = new ArrayList<Etape>() ;
	final private int NOMBRE_MAX_INGREDIENTS = 40;
	private int compteur_ingredient = 0;
	final private int NOMBRE_MAX_ETAPES = 40;
	private int compteur_etape = 0;
	
	public Recette( RecetteBuilder r ) {
		r.build( this );
	}
	
	protected void titre (String t) {
		this.titre = t;
	}
	
	protected void unite_quantite(String u) {
		this.unite_quantite = u;
	}
	protected void quantite (int q) {
		this.quantite =q;
	}
	
	protected String[] temps_preparation (String t) {
		this.temps_preparation = t.split(":");
		//String[] t = t.split(":") ;
		return this.temps_preparation ;
	}
	
	protected void unite_temps (String u) {
		this.unite_temps =u;
	}

	
	protected void ingredients_recette(Ingredient ... values ) {
		this.ingredients_recette = new Ingredient [NOMBRE_MAX_INGREDIENTS];
		for (Ingredient i : values) {
			this.ingredients_recette[compteur_ingredient] = i;
			compteur_ingredient ++;
		}
	}
	
	protected void etapes_recette (Etape ... values) {
		this.etapes_recette = new Etape [NOMBRE_MAX_ETAPES];
		for (Etape e : values) {
			this.etapes_recette[compteur_etape] = e;
			compteur_etape ++ ;
		}
	}
	
	//convertir le string recu en unite de temps
	public Unite obtenirUnite(String unite) {
		Unite resultat = null;
		
		switch (unite) {
		case "heure":
			resultat = new Heure();
			break ;
		case "Portion":
			resultat = new Portion();
			break ;
		case "minute":
			resultat = new Minute();
			break ;
		case "personne":
			resultat = new Personne();
			break ;
		case "tasse":
			resultat = new Tasse();
			break ;
		default:
			resultat = null;
		}
		return resultat ;
	}

	//convertir le tableau d'ingredients en string afin de l'afficher
	public String toStringIngredients(Ingredient[] ing) {
		String resultat = "" ;
		for (int i=1; i<=ing.length; i++) {
			if (ing[i-1] == null){
				resultat = resultat + "" ;
			}
			else {
				resultat = resultat +i+ ". " +ing[i-1] ;
				resultat = resultat + "\n" ;
			}
		}
		return resultat ;
	}
	
	//convertir le tableau d'etapes en string afin de l'afficher
	public String toStringEtapes(Etape[] et) {
		String resultat = "" ;
		for (int i=1; i<=et.length; i++) {
			if (et[i-1] == null){
				resultat = resultat + "" ;
			}
			else {
				resultat = resultat +i+ ". " +et[i-1] ;
				resultat = resultat + "\n" ;
			}
		}
		return resultat ;
	}
	
	@Override
	public String toString() {
		if (this.temps_preparation[0].equals("00")){
			return this.titre + "\n" +
					"pour " + this.quantite + " " +obtenirUnite(this.unite_quantite).toString(this.quantite)+ "\n" +
					"Temps de preparation" + ": " +this.temps_preparation[1]+ " " +obtenirUnite(this.unite_temps).toString(Integer.parseInt(this.temps_preparation[1]))+ "\n \n"+
					"Ingredients \n" + toStringIngredients(this.ingredients_recette) + "\n" +
					"Preparation \n" + toStringEtapes(this.etapes_recette) ;
		}
		else {
			return this.titre + "\n" +
					"pour " + this.quantite + " " + obtenirUnite(this.unite_quantite).toString(this.quantite)+ "\n" +
					"Temps de preparation" + ": " + this.temps_preparation[0]+ " " + obtenirUnite(this.unite_temps).toString(Integer.parseInt(this.temps_preparation[0]))+ " " +this.temps_preparation[1]+ " " + new Minute().toString(Integer.parseInt(this.temps_preparation[1]))+  "\n \n"+
					"Ingredients \n" + toStringIngredients(this.ingredients_recette) + "\n" +
					"Preparation \n" + toStringEtapes(this.etapes_recette)  ;
		}
		
	}
}
