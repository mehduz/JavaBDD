package beans;

public class Authentication {

	private String Login;
	private String MDP;
	private long ID_personne;
	private int Type_personne;

	public Authentication(String login, String mDP, long iD_personne,
			int type_personne) {
		super();
		Login = login;
		MDP = mDP;
		ID_personne = iD_personne;
		Type_personne = type_personne;
	}

	public Authentication() {

	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getMDP() {
		return MDP;
	}

	public void setMDP(String mDP) {
		MDP = mDP;
	}

	public long getID_personne() {
		return ID_personne;
	}

	public void setID_personne(long iD_personne) {
		ID_personne = iD_personne;
	}

	public int getType_personne() {
		return Type_personne;
	}

	public void setType_personne(int type_personne) {
		Type_personne = type_personne;
	}

	@Override
	public String toString() {
		return "Authentication [Login=" + Login + ", MDP=" + MDP
				+ ", ID_personne=" + ID_personne + ", Type_personne="
				+ Type_personne + "]";
	}

}
