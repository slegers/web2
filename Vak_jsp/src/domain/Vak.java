package domain;

public class Vak {
	
	private String naam;
	private int studiePunten;
	private String jaar;
	
	public Vak (String naam, int studiePunten, String jaar) {
		this.naam = naam;
		this.studiePunten = studiePunten;
		this.jaar = jaar;
	}
	
	public String getNaam () {
		return this.naam;
	}
	
	public int getStudiePunten () {
		return this.studiePunten;
	}
	
	public String getJaar () {
		return this.jaar;
	}

}
