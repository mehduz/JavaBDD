package beans;

public class Authentication {


	private long ID_personne;
	private int Type_personne;

	public Authentication(long iD_personne,
			int type_personne) {
		super();

		ID_personne = iD_personne;
		Type_personne = type_personne;
	}

	public Authentication() {

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
		return "Authentication: "
				+ " ID_personne=" + ID_personne + ", Type_personne="
				+ Type_personne + "]";
	}

}
