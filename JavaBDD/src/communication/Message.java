package communication;

import java.io.Serializable;

 public abstract class Message implements Serializable {
	
	protected String type;
	
	public Message(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
