package communication;

import java.util.EventListener;

public interface ResponseListener extends EventListener{
	public void onResponseReceived();
}
