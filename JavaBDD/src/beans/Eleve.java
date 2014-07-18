package beans;

import java.util.Date;

public class Eleve extends Personne {
	
	private long Matricule;
	private Date Date_naissance;
	private String Ville_naissance;
	private String Pays_naissance;
	private String Sexe;
	private Date Date_inscription;
	private String Etablissement_prec;
	private String Photo;
	private String Rue;
	private long Code_postal;
	private String Ville;
	private String Email;
	private String Contact;
	private String Vaccination;
	private String Allergie;
	private String Remarques_medicale;
		
	public Eleve(String iD_personne, String nom, String prenom, String email,
			long tel_domicile, long tel_mobile, long matricule,
			Date date_naissance, String ville_naissance, String pays_naissance,
			String sexe, Date date_inscription, String etablissement_prec,
			String photo, String rue, long code_postal, String ville,
			String email2, String contact, String vaccination, String allergie,
			String remarques_medicale) {
		super(iD_personne, nom, prenom, email, tel_domicile, tel_mobile);
		Matricule = matricule;
		Date_naissance = date_naissance;
		Ville_naissance = ville_naissance;
		Pays_naissance = pays_naissance;
		Sexe = sexe;
		Date_inscription = date_inscription;
		Etablissement_prec = etablissement_prec;
		Photo = photo;
		Rue = rue;
		Code_postal = code_postal;
		Ville = ville;
		Email = email2;
		Contact = contact;
		Vaccination = vaccination;
		Allergie = allergie;
		Remarques_medicale = remarques_medicale;
	}
	
	public long getMatricule() {
		return Matricule;
	}
	public void setMatricule(long matricule) {
		Matricule = matricule;
	}
	public Date getDate_naissance() {
		return Date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		Date_naissance = date_naissance;
	}
	public String getVille_naissance() {
		return Ville_naissance;
	}
	public void setVille_naissance(String ville_naissance) {
		Ville_naissance = ville_naissance;
	}
	public String getPays_naissance() {
		return Pays_naissance;
	}
	public void setPays_naissance(String pays_naissance) {
		Pays_naissance = pays_naissance;
	}
	public String getSexe() {
		return Sexe;
	}
	public void setSexe(String sexe) {
		Sexe = sexe;
	}
	public Date getDate_inscription() {
		return Date_inscription;
	}
	public void setDate_inscription(Date date_inscription) {
		Date_inscription = date_inscription;
	}
	public String getEtablissement_prec() {
		return Etablissement_prec;
	}
	public void setEtablissement_prec(String etablissement_prec) {
		Etablissement_prec = etablissement_prec;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public String getRue() {
		return Rue;
	}
	public void setRue(String rue) {
		Rue = rue;
	}
	public long getCode_postal() {
		return Code_postal;
	}
	public void setCode_postal(long code_postal) {
		Code_postal = code_postal;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getVaccination() {
		return Vaccination;
	}
	public void setVaccination(String vaccination) {
		Vaccination = vaccination;
	}
	public String getAllergie() {
		return Allergie;
	}
	public void setAllergie(String allergie) {
		Allergie = allergie;
	}
	public String getRemarques_medicale() {
		return Remarques_medicale;
	}
	public void setRemarques_medicale(String remarques_medicale) {
		Remarques_medicale = remarques_medicale;
	}
	
	
}
