package beans;

public class Contact extends Personne{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2048111907690260707L;
	
	private long ID_contact;
	private String Adresse;

	public Contact(long iD_personne, String nom, String prenom, String email,
			long tel_domicile, long tel_mobile, long iD_contact, String adresse) {
		super(iD_personne, nom, prenom, email, tel_domicile, tel_mobile);

	}
	
	public Contact() {
		super();
	}

	public long getID_contact() {
		return ID_contact;
	}

	public void setID_contact(long iD_contact) {
		ID_contact = iD_contact;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

}
