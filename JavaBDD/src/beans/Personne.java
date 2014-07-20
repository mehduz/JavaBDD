package beans;

import java.io.Serializable;

public class Personne implements Serializable {
	
	private long ID_personne;
	private String Nom;
	private String Prenom;
	private String Email;
	private long Tel_domicile;
	private long Tel_mobile;
	
	public Personne() {

	}

	public Personne(long iD_personne, String nom, String prenom,
			String email, long tel_domicile, long tel_mobile) {
		super();
		ID_personne = iD_personne;
		Nom = nom;
		Prenom = prenom;
		Email = email;
		Tel_domicile = tel_domicile;
		Tel_mobile = tel_mobile;
	}
	
	public long getID_personne() {
		return ID_personne;
	}
	public void setID_personne(long iD_personne) {
		ID_personne = iD_personne;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getTel_domicile() {
		return Tel_domicile;
	}
	public void setTel_domicile(long tel_domicile) {
		Tel_domicile = tel_domicile;
	}
	public long getTel_mobile() {
		return Tel_mobile;
	}
	public void setTel_mobile(long tel_mobile) {
		Tel_mobile = tel_mobile;
	}
	
	
	
}
