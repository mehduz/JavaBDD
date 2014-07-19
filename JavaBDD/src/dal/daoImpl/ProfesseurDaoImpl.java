package dal.daoImpl;

import beans.Professeur;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.ProfesseurDao;

public class ProfesseurDaoImpl extends SuperDaoImpl implements ProfesseurDao {

	public ProfesseurDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creer(Professeur classe) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Professeur trouver(String id_prof) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
