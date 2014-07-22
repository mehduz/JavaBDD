package dal.daoImpl;

import dal.DAOFactory;

public class SuperDaoImpl  {

	 protected DAOFactory   daoFactory;
	 
	  public SuperDaoImpl( DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	    }	
	
}
