package beans;

public class Medecin extends Personne{
	
	private long ID_medecin;
	private long ID_personne;
	
	public Medecin(long iD_medecin, long iD_personne) {
		super();
		ID_medecin = iD_medecin;
		ID_personne = iD_personne;
	}
	
	public Medecin () {
		
	}

	public long getID_medecin() {
		return ID_medecin;
	}

	public void setID_medecin(long iD_medecin) {
		ID_medecin = iD_medecin;
	}

	public long getID_personne() {
		return ID_personne;
	}

	public void setID_personne(long iD_personne) {
		ID_personne = iD_personne;
	}

	@Override
	public String toString() {
		return "Medecin [ID_medecin=" + ID_medecin + ", ID_personne="
				+ ID_personne + "]";
	}
	
	
	
	

}
