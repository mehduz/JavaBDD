package dal.daoImpl;

import beans.Personne;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.PersonneDao;

public class PersonneDaoImpl extends SuperDaoImpl implements PersonneDao {

//	/*Cr�ation de la personne*/
//	INSERT INTO personne (Nom, Prenom, Email, Tel_domicile, Tel_mobile) VALUES (?, ?, ?, ?, ?);
//	/*R�cup�ration de son ID_personne g�n�rer par auto_increment*/
//	SELECT ID_personne FROM personne WHERE Nom = ? AND Prenom = ? AND Email = ?;
//	/*Cr�ation du profil contact � l'aide de l'ID_personne pr�c�demment r�cup�r�*/
//	INSERT INTO contact (Adresse_contact, ID_personne) VALUES (?, ?);
	
	public PersonneDaoImpl(DAOFactory daoFactory) {
		super(daoFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creer(Personne classe) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Personne trouver(String nom_matiere) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	


}
