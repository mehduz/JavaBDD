package beans;

public class Suivi {
	
	private long Note_CC;
	private long Note_examen;
	
	public Suivi(long note_CC, long note_examen) {
		Note_CC = note_CC;
		Note_examen = note_examen;
	}
	
	public Suivi() {
		
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
