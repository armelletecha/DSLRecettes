package uqam.mgl7460.projet3.dsl.recettes;

import unites.Cuillere_a_soupe;
import unites.Cuillere_a_the;
import unites.Heure;
import unites.Minute;
import unites.Personne;
import unites.Portion;
import unites.Tasse;
import unites.Unite;

public class Ingredient {
	private String nom;
	private int quantite ;
	private String uniteQuantite ;

	public Ingredient(String nom, int quantite, String unite) {
		this.nom = nom ;
		this.quantite = quantite ;
		this.uniteQuantite = unite ;
	}
	
	public Ingredient(String nom, int quantite) {
		this.nom = nom ;
		this.quantite = quantite ;
	}

	protected void nom (String n) {
		this.nom= n;
	}

	protected void quantite (int q) {
		quantite =q;
	}

	protected void uniteQuantite (String u) {
		this.uniteQuantite = u;
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
			case "cuillere a soupe":
				resultat = new Cuillere_a_soupe();
				break ;
			case "cuillere a the":
				resultat = new Cuillere_a_the();
				break ;
			default:
				resultat = null;
			}
			return resultat ;
		}
	
	public String toString() {
		if (this.uniteQuantite == null) {
			return this.quantite + " " + this.nom ;
		}
		else {
			return this.quantite + " " + obtenirUnite(this.uniteQuantite).toString(this.quantite) + " de " + this.nom ;
		}
	}
}
