package beans;

public class Vaccine {

	private long Matricule;
	private long ID_personne;
	private long ID_vaccin;

	public Vaccine(long matricule, long iD_personne, long iD_vaccin) {
		super();
		Matricule = matricule;
		ID_personne = iD_personne;
		ID_vaccin = iD_vaccin;
	}

	public Vaccine() {

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

	public long getID_vaccin() {
		return ID_vaccin;
	}

	public void setID_vaccin(long iD_vaccin) {
		ID_vaccin = iD_vaccin;
	}

	@Override
	public String toString() {
		return "Vaccine [Matricule=" + Matricule + ", ID_personne="
				+ ID_personne + ", ID_vaccin=" + ID_vaccin + "]";
	}

}
