package communication;

import dal.DAOFactory;

public class ActionIdentification extends Action{

	@Override
	public void execute() {
		DAOFactory.getInstance();
	}
	
}
