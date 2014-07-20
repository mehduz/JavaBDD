package communication;

import java.io.Serializable;

 public abstract class Message implements Serializable {
	
	protected String type;
	
	public Message(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
}
