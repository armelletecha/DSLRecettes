package uqam.mgl7460.projet3.dsl.recettes;

public class Etape {
	private String description ;
	
	public Etape(String description) {
		this.description = description ;
	}
	
	protected void description (String d) {
		this.description = d;
	}
	
	public String toString() {
		return description.toString() ;
	}
}
