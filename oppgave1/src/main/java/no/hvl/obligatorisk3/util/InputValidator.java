package no.hvl.obligatorisk3.util;

public class InputValidator {

	public static final String ER_BOKSTAV = "[a-zA-æøåÆØÅ ]";
	public static final String TO_FLERE = "{2,}";
	
	
	//Sjekker om inputen av vare er en bokstav siden jeg ikke ønsker at det skal være tall
	//Sjekker også at det er to eller flere bokstaver.
	public static boolean gyldigVare(String varer) {
		return varer != null && varer.matches("^" + ER_BOKSTAV + TO_FLERE +  "$");
	}
}
