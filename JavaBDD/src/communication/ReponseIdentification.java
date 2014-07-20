package communication;

public class ReponseIdentification extends Reponse{ 
	
	private boolean logged;

	protected ReponseIdentification(boolean logged) {
		super(ReponseIdentification.class.getName());
		this.logged = logged;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}
	
}
