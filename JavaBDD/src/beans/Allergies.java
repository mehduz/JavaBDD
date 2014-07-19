package beans;

public class Allergies {
	
	private long ID_allergie;
	private String Libelle;
	
	public Allergies(long iD_allergie, String libelle) {
		super();
		ID_allergie = iD_allergie;
		Libelle = libelle;
	}

	public Allergies() {
		
	}

	public long getID_allergie() {
		return ID_allergie;
	}

	public void setID_allergie(long iD_allergie) {
		ID_allergie = iD_allergie;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	@Override
	public String toString() {
		return "Allergies [ID_allergie=" + ID_allergie + ", Libelle=" + Libelle
				+ "]";
	}

}
