package uqam.mgl7460.projet3.dsl.recettes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import unites.Tasse;

public class IngredientTest {
	 
	Ingredient ingredient = null ;
	
	/*@Before
	public void setUp() throws Exception {
		ingredient = new Ingredient("oignons", 4) ;	
	}*/
	
	@Test
	public void ingredientSansUniteTest() {
		ingredient = new Ingredient("oignons", 4) ;	
		assertEquals(ingredient.toString(), "4 oignons") ;
	}
	
	@Test
	public void ingredientAvecUniteSingulierTest() {
		ingredient = new Ingredient("bouillon de poulet", 1, "tasse") ;
		assertEquals(ingredient.toString(), "1 tasse de bouillon de poulet") ;
	}
	
	@Test
	public void ingredientAvecUnitePlurielTest() {
		ingredient = new Ingredient("bouillon de poulet", 2, "tasse") ;
		assertEquals(ingredient.toString(), "2 tasses de bouillon de poulet") ;
	}
}
