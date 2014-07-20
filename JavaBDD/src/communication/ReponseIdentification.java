package communication;

import dal.DAOPermission;
import beans.Personne;

public class ReponseIdentification extends Reponse{ 
	
	private boolean logged;
	private Personne p;
	private DAOPermission permission;
	
	
	protected ReponseIdentification(boolean logged, Personne p, DAOPermission permission) {
		super(ReponseIdentification.class.getName());
		this.logged = logged;
		this.p =p;
		this.permission = permission;
	}

	public boolean isLogged() {
		return logged;
	}
	public Personne getPersonne(){
		return this.p;
	}
	public DAOPermission getPermission() {
		return permission;
	}

}
