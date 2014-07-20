package communication;

import javax.xml.ws.Response;

public abstract class Action {
	
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	protected Action(Message message) {
		this.message = message;
	}

	public abstract void execute();
	public abstract Reponse getReponse();
}