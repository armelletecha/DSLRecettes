package uqam.mgl7460.projet3.dsl.recettes;

public class Ingredient {
	private String nom;
	private int quantite ;
	private Unite uniteQuantite ;
	
	
	public Ingredient(String nom, int quantite, Unite unite) {
		this.nom = nom ;
		this.quantite = quantite ;
		this.uniteQuantite = unite ;
	}
	
	public Ingredient(String nom, int quantite) {
		this.nom = nom ;
		this.quantite = quantite ;
	}
	
	public String toString() {
		if (uniteQuantite == null) {
			return this.quantite + " " + this.nom ;
		}
		else {
			return this.quantite + " " + this.uniteQuantite.toString() + " de " + this.nom ;
		}
	}
}
