package communication;
import beans.Eleve;
import dal.DAOFactory;
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
		EleveDao elevedao= daoFactory.getEleveDao();
		MessageIdentification msg = (MessageIdentification) super.getMessage();
		Eleve romain = elevedao.trouver(msg.getLogin(),msg.getPassword());
		reponse = new ReponseIdentification(romain != null);
	}
}