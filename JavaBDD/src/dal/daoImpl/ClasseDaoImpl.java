package dal.daoImpl;

import beans.Classe;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.ClasseDao;

public class ClasseDaoImpl extends SuperDaoImpl implements ClasseDao  {

	public ClasseDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creer(Classe classe) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Classe trouver(String nom_classe) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
