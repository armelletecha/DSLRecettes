package uqam.mgl7460.projet3.dsl.recettes;

public class Etape {
	private String description ;
	
	public Etape(String description) {
		this.description = description ;
	}
	
	public String getDescription() {
		return this.description ;
	}
	
	public void setDescription(String description) {
		this.description = description ;
	}
	
	public String toString() {
		return description.toString() ;
	}
}
