package dal.daoImpl;

import beans.Matiere;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.MatiereDao;
 
public class MatiereDaoImpl  extends SuperDaoImpl implements MatiereDao {

	public MatiereDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creer(Matiere classe) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Matiere trouver(String nom_matiere) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
