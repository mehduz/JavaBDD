package beans;

public class Vaccins {
	
	private long ID_vaccin;
	private String Libelle;
	
	public Vaccins(long iD_vaccin, String libelle) {
		ID_vaccin = iD_vaccin;
		Libelle = libelle;
	}

	public Vaccins() {
		
	}

	public long getID_vaccin() {
		return ID_vaccin;
	}

	public void setID_vaccin(long iD_vaccin) {
		ID_vaccin = iD_vaccin;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	@Override
	public String toString() {
		return "Vaccins [ID_vaccin=" + ID_vaccin + ", Libelle=" + Libelle + "]";
	}
	
	

}
