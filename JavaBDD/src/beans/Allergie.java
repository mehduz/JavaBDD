package beans;

public class Allergie {
	
	private long ID_allergie;
	private String Libelle;
	
	public Allergie(long iD_allergie, String libelle) {
		ID_allergie = iD_allergie;
		Libelle = libelle;
	}

	public Allergie(String libelle) {
		this.setLibelle(libelle);
	}

	public long getID_allergie() {
		return ID_allergie;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	@Override
	public String toString() {
		return "Allergies [ID_allergie=" + ID_allergie + ", Libelle=" + Libelle	+ "]";
	}

}
