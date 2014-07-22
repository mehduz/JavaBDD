package beans;

public class Professeur extends Personne{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1967960103689136762L;
	
	private long ID_prof;
	
	public Professeur() {
		super();
	}

	public Professeur(long iD_personne, String nom, String prenom,
			String email, long tel_domicile, long tel_mobile, long iD_prof) {
		super(iD_personne, nom, prenom, email, tel_domicile, tel_mobile);
		ID_prof = iD_prof;
	}
	
	public long getID_prof() {
		return ID_prof;
	}

	public void setID_prof(long iD_prof) {
		ID_prof = iD_prof;
	}
	
}
