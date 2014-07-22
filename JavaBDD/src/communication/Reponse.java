package communication;

import java.io.Serializable;

public abstract class Reponse implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2326236217996147823L;
	
	protected String type;
	
	public Reponse(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
