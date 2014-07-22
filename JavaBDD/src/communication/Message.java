package communication;

import java.io.Serializable;

 public abstract class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7691193600710321389L;
	
	protected String type;
	
	public Message(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
}
