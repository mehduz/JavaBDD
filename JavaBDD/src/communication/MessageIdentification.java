package communication;

public class MessageIdentification extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 546111143346443771L;
	
	private String login, password;

	public MessageIdentification(String type, String login, String password) {
		super(type);
		this.login = login; 
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}