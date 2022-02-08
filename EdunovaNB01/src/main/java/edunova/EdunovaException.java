package edunova;

public class EdunovaException extends Exception {
	
	private String poruka;
	
	public EdunovaException(String poruka) {
		super(poruka);
		this.setPoruka("Prevedeno " + poruka);
	}

	public String getPoruka() {
		return poruka;
	}

	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}

}
