package no.hvl.obligatorisk3.handleliste;

import java.util.ArrayList;
import java.util.List;

public class Handleliste {
	
	private List<Vare> varer = new ArrayList<>(); 
	
	public void leggTilVare(Vare v) {
		varer.add(v);
	}
	
	//Slette vare, filtrerer ut med en stream fra listen.
	public void slettVare(String v) {
		Vare k = varer.stream().filter(p -> p.getNavn().equals(v)).findFirst().orElse(null);
		varer.remove(k);
	}
	
	public List<Vare> getVarer() {
		return varer;
	}
	
	public int size() {
		return varer.size();
	}
	
	
}
