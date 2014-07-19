package dal.daoImpl;

import beans.Contact;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.ContactDao;

public class ContactDaoImpl  extends SuperDaoImpl implements ContactDao {

	public ContactDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creer(Contact classe) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contact trouver(String id_contact) throws DAOException {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

}
