package uqam.mgl7460.projet3.dsl.recettes;

import static org.junit.Assert.*;

import org.junit.Test;

public class IngredientTest {
	 
	Ingredient ingredient = null ;
	
	//retourne un ingredient sans unite
	@Test
	public void ingredientSansUniteTest() {
		ingredient = new Ingredient("oignons", 4) ;	
		assertEquals(ingredient.toString(), "4 oignons") ;
	}
	
	//retourne un ingredient avec l unite au singulier car quantite = 1
	@Test
	public void ingredientAvecUniteSingulierTest() {
		ingredient = new Ingredient("bouillon de poulet", 1, "tasse") ;
		assertEquals(ingredient.toString(), "1 tasse de bouillon de poulet") ;
	}
	
	//retourne un ingredient avec l unite au pluriel car quantite > 1
	@Test
	public void ingredientAvecUnitePlurielTest() {
		ingredient = new Ingredient("bouillon de poulet", 2, "tasse") ;
		assertEquals(ingredient.toString(), "2 tasses de bouillon de poulet") ;
	}
}
