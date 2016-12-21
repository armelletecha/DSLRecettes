package uqam.mgl7460.projet3.dsl.recettes;

import static org.junit.Assert.*;

import org.junit.Test;

import unites.Cuillere_a_soupe;
import unites.Tasse;
import unites.Unite;

public class UniteTest {
	 
	Unite unite = null ;
	
	//retourne le singulier d une unite compose
	@Test
	public void uniteComposeSingulierTest() {
		unite = new Cuillere_a_soupe() ;	
		assertEquals(unite.toString(1), "cuillere a soupe") ;
	}
	
	//retourne le pluriel d une unite compose
	@Test
	public void uniteComposePlurielTest() {
		unite = new Cuillere_a_soupe() ;	
		assertEquals(unite.toString(2), "cuilleres a soupe ") ;
	}
	
	//retourne le singulier d une unite simple
	@Test
	public void uniteSimpleSingulierTest() {
		unite = new Tasse() ;	
		assertEquals(unite.toString(1), "tasse") ;
	}
	
	//retourne le pluriel d une unite simple
	@Test
	public void uniteSimplePlurielTest() {
		unite = new Tasse() ;	
		assertEquals(unite.toString(2), "tasses") ;
	}
}
