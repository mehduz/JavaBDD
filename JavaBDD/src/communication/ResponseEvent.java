package communication;

import java.util.EventObject;

public class ResponseEvent extends EventObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1006822852744073857L;

	public ResponseEvent(Reponse r) {
		super(r);
	}
	
}
