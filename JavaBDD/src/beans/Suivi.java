package beans;

public class Suivi {
	
	private Matiere matiere;
	private Eleve eleve;
	private long Note_CC;
	private long Note_examen;

	
	public Suivi (Matiere matiere, Eleve eleve, long Note_CC, long Note_examen) {
		
		this.matiere = matiere;
		this.eleve = eleve;
		this.Note_CC = Note_CC;
		this.Note_examen = Note_examen;
		
	}

	public Suivi() {
		
		this.matiere = new Matiere();
		this.eleve = new Eleve();
		
	}
	
	
	public long getMatricule() {
		return eleve.getMatricule();
	}

	public void setMatricule(long matricule) {
		eleve.setMatricule(matricule);
	}

	public long getID_personne() {
		return eleve.getID_personne();
	}

	public void setID_personne(long iD_personne) {
		eleve.setID_personne(iD_personne);
	}

	public String getNom_matiere() {
		return matiere.getNom_matiere();
	}

	public void setNom_matiere(String nom_matiere) {
		this.matiere.setNom_matiere(nom_matiere);
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
	
	public Eleve getEleve() {
		
		return this.eleve;
		
	}
	
	public void setEleve(Eleve eleve) {
		
		this.eleve = eleve;
		
	}

}
