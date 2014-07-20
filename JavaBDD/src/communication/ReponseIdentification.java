package communication;

import beans.Personne;

public class ReponseIdentification extends Reponse{ 
	
	private boolean logged;
	private Personne p;
	
	protected ReponseIdentification(boolean logged, Personne p) {
		super(ReponseIdentification.class.getName());
		this.logged = logged;
		this.p =p;
	}

	public boolean isLogged() {
		return logged;
	}
	
	public Personne getPersonne(){
		return this.p;
	}
}
