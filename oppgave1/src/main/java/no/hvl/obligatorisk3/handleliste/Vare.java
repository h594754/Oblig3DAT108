package no.hvl.obligatorisk3.handleliste;


public class Vare {

	private String navn; 
	
	public Vare(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	@Override
	public String toString() {
		return navn;
	}
	
}
