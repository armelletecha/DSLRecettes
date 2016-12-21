package unites;

public class Unite {
	public String nom ;
	
	public Unite() {
	}
	
	
	public String uniteMasculin() {
		return this.nom ;
	}
	
	public String unitePluriel() {
		String[] tab = this.uniteMasculin().split(" ") ;
		if (tab.length == 1)
			return this.uniteMasculin() + "s" ;
		else {
			String s=tab[0] + "s " ;
			for (int i=1; i<tab.length; i++) {
				s = s + tab[i] ;
				s = s + " " ;
			}
		return s;
		}
	}
	
	public String toString(int quantite) {
		if (quantite == 1)
			return this.uniteMasculin();
		else 
			return this.unitePluriel();
	}
}
