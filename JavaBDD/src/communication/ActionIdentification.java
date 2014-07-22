package communication;

import beans.Authentication;
import beans.Personne;
import dal.DAOFactory;
import dal.DAOPermission;
import dal.dao.AuthenticationDao;
import dal.dao.PersonneDao;

public class ActionIdentification extends Action {

	private ReponseIdentification reponse = null;

	public ReponseIdentification getReponse() {
		return reponse;
	}

	public ActionIdentification(Message msg) {
		super(msg);
	}

	@Override
	public void execute(){
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		AuthenticationDao authenticationDao = daoFactory.getAuthenticationDao();
		MessageIdentification msg = (MessageIdentification) super.getMessage();
		Authentication authentication = null;
		Personne p = null;
		
		authentication = authenticationDao.trouver(msg.getLogin(),msg.getPassword());
		if(authentication == null){
			reponse = new ReponseIdentification(false, null, null);
			return;
		}
		PersonneDao personneDao= daoFactory.getPersonneDao();
		p = personneDao.trouver(authentication.getID_personne());
		reponse = new ReponseIdentification(p != null, p, DAOPermission.fromInt(authentication.getType_personne()));
	}
}