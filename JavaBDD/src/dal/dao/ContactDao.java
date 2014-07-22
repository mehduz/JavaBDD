package dal.dao;

import java.util.ArrayList;

import beans.Contact;
import dal.DAOException;

public interface ContactDao {
	
	int creer( Contact contact ) throws DAOException;
	
	void supprimer(Contact contact) throws DAOException;

	Contact trouver( int id_personne ) throws DAOException;
	
	public ArrayList<Contact> getAll() throws DAOException;

}
