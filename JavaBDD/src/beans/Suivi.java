package beans;

public class Suivi {
	
	private long Note_CC;
	private long Note_examen;
	private long Matricule;
	private long ID_personne;
	private long Nom_matiere;
	
	public Suivi(long note_CC, long note_examen) {
		Note_CC = note_CC;
		Note_examen = note_examen;
	}
	
	public Suivi() {
		
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

	public long getNom_matiere() {
		return Nom_matiere;
	}

	public void setNom_matiere(long nom_matiere) {
		Nom_matiere = nom_matiere;
	}

	public long getNote_CC() {
		return Note_CC;
	}
	public void setNote_CC(long note_CC) {
		Note_CC = note_CC;
	}
	public long getNote_examen() {
		return Note_examen;
	}
	public void setNote_examen(long note_examen) {
		Note_examen = note_examen;
	}

}
