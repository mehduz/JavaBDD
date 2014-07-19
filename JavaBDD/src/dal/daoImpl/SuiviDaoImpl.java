package dal.daoImpl;

import beans.Suivi;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.SuivreDao;

public class SuiviDaoImpl extends SuperDaoImpl implements SuivreDao {
	
	public SuiviDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creer(Suivi classe) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Suivi trouver(String email) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
 