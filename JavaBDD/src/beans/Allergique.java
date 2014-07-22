package beans;

public class Allergique {

	private long Matricule;
	private long ID_personne;
	private long ID_allergie;
	
	public Allergique() {

	}

	public Allergique(long matricule, long iD_personne, long iD_allergie) {
		super();
		Matricule = matricule;
		ID_personne = iD_personne;
		ID_allergie = iD_allergie;
	}

	public long getMatricule() {
		return Matricule;
	}

	public void setMatricule(long matricule) {
		Matricule = matricule;
	}

	public long getID_personne() {
		return ID_personne;
	}

	public void setID_personne(long iD_personne) {
		ID_personne = iD_personne;
	}

	public long getID_allergie() {
		return ID_allergie;
	}

	public void setID_allergie(long iD_allergie) {
		ID_allergie = iD_allergie;
	}

	@Override
	public String toString() {
		return "Allergique [Matricule=" + Matricule + ", ID_personne="
				+ ID_personne + ", ID_allergie=" + ID_allergie + "]";
	}

}
