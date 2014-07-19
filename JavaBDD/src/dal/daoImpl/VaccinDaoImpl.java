package dal.daoImpl;

import beans.Vaccin;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.VaccinDao;

public class VaccinDaoImpl extends SuperDaoImpl implements VaccinDao {

	public VaccinDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int creer(Vaccin classe) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vaccin trouver(int idPersonne) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
