package dal.daoImpl;

import java.beans.Statement;

import dal.DAOException;
import dal.DAOFactory;
import dal.dao.EleveDao;
import beans.Eleve;

public class EleveDaoImpl implements EleveDao {

	 private DAOFactory   daoFactory;
	 
	    EleveDaoImpl( DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	    }
	
	@Override
	public void creer(Eleve eleve) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Eleve trouver(String email) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eleve trouver(String login, String mdp) throws DAOException {

	}

}	
