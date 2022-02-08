package edunova.program;

import java.math.BigDecimal;

public class Mobitel {
	
	private int sifra;
	private String naziv;
	private BigDecimal cijena;
	
	public Mobitel() {
		
	}
	
	public Mobitel(int sifra, String naziv, BigDecimal cijena) {
		this.sifra = sifra;
		this.naziv = naziv;
		this.cijena = cijena;
	}
	
	public int getSifra() {
		return sifra;
	}
	public void setSifra(int sifra) {
		this.sifra = sifra;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public BigDecimal getCijena() {
		return cijena;
	}
	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}

	@Override
	public String toString() {
		return   naziv + ", " + cijena + " kn";
	}
	
	

}
