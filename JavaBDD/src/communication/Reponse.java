package communication;

import java.io.Serializable;

public abstract class Reponse implements Serializable{ 
	
protected String type;
	
	public Reponse(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
