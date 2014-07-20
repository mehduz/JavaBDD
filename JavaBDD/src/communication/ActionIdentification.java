package communication;
import beans.Authentication;
import beans.Eleve;
import dal.DAOFactory;
import dal.DAOPermission;
import dal.dao.AuthenticationDao;
import dal.dao.EleveDao;

public class ActionIdentification extends Action{

	private ReponseIdentification reponse = null;
	
	public ReponseIdentification getReponse() {
		return reponse;
	}

	public ActionIdentification(Message msg){
		super(msg);
	}
	
	@Override
	public void execute(){
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		AuthenticationDao authenticationDao = daoFactory.getAuthenticationDao();
		MessageIdentification msg = (MessageIdentification) super.getMessage();
		int permission;
		
		try{
			Authentication authentication = authenticationDao.trouver(msg.getLogin(),msg.getPassword());
			permission =  authentication.getType_personne();
		}
		catch(Exception e){
			return;
		}
		
		
		//EleveDao elevedao= daoFactory.getEleveDao();
		//Eleve romain = elevedao.trouver();
		//reponse = new ReponseIdentification(romain != null, romain); 
	}
}