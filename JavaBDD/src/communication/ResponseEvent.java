package communication;

import java.util.EventObject;

public class ResponseEvent extends EventObject{
	
	public ResponseEvent(Reponse r) {
		super(r);
	}
}
