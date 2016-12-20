package uqam.mgl7460.projet3.dsl.recettes;

import java.util.ArrayList;

public class Recette {
	private String titre;
	private int quantite;
	private Unite unite_quantite;
	private String temps_preparation;
	private String unite_temps;
	
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>() ;
	private ArrayList<Etape> etapes = new ArrayList<Etape>() ;
	
	Recette( RecetteBuilder r ) {
		r.build( this );
	}
	
	//*******Setters**********************
	protected void setTitre( String t ) {
		titre = t;
	}
	
	protected void setQuantite( int q ){
		this.quantite = q;
	}
	
	protected void setUniteQuantite(Unite u) {
		this.unite_quantite = u;
	}
	
	protected void setTempsPreparation(String t) {
		this.temps_preparation = t;
	}
	
	protected void setUniteTemps( String temps ) {
		this.unite_temps = temps ;
	}
	
	protected void setIngredients( ArrayList<Ingredient> ingredient ) {
		for (int i=0; i<ingredient.size(); i++)
			this.ingredients.add(ingredient.get(i)) ;
	}
	
	protected void setEtapes( ArrayList<Etape> etape ) {
		for (int i=0; i<etape.size(); i++)
			this.etapes.add(etape.get(i)) ;
	}
	
	//*****getters***************
	protected String getTitre() {
		return this.titre ;
	}
	
	protected int getQuantite(){
		return this.quantite;
	}
	
	protected Unite getUniteQuantite() {
		return this.unite_quantite;
	}
	
	protected String[] getTempsPreparation() {
		String[] t = this.temps_preparation.split(":") ;
		return t ;
	}
	
	protected String[] getUniteTemps() {
		String[] t = this.unite_temps.split(":") ;
		return t ;
	}
	
	protected ArrayList<Ingredient> getIngredients() {
		return this.ingredients ;
	}
	
	protected ArrayList<Etape> getEtapes() {
		return this.etapes ;
	}
	
	//********methodes pour l affichage des ingredients et des etapes
	public String toStringIngredients(ArrayList<Ingredient> listeIngredients) {
		String resultat = "";
		for (int i=0; i<listeIngredients.size(); i++)
			resultat = resultat + listeIngredients.get(i).toString()+ "\n" ;
		return resultat ;
	}
	
	public String toStringEtapes(ArrayList<Etape> listeEtapes) {
		String resultat = "";
		for (int i=1; i<listeEtapes.size(); i++)
			resultat = resultat + i+ ". " +listeEtapes.get(i).toString()+ "\n" ;
		return resultat ;
	}
	
	@Override
	public String toString() {
		if (this.getTempsPreparation()[1] == "00"){
			return this.getTitre() + "\n" +
					"pour " + this.getQuantite() + " " +this.getUniteQuantite().toString()+ "\n" +
					"Temps de preparation" + ": " +this.getTempsPreparation()[1]+ " " +this.getUniteTemps()[1]+ "\n \n"+
					"Ingredients \n" + toStringIngredients(this.getIngredients())+ "\n" +
					"Preparation \n" + toStringEtapes(this.getEtapes()) ;
		}
		else {
			return this.getTitre() + "\n" +
					"pour " + this.getQuantite() + " " +this.getUniteQuantite().toString()+ "\n" +
					"Temps de preparation" + ": " +this.getTempsPreparation()[0]+ " " +this.getUniteTemps()[0]+ " " +this.getTempsPreparation()[1]+ " " +this.getUniteTemps()[1]+  "\n \n"+
					"Ingredients \n" + toStringIngredients(this.getIngredients())+ "\n" +
					"Preparation \n" + toStringEtapes(this.getEtapes()) ;
		}
		
	}
}
