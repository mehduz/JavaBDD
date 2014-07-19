package dal.daoImpl;

import beans.Personne;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.PersonneDao;

public class PersonneDaoImpl extends SuperDaoImpl implements PersonneDao {

//	/*Création de la personne*/
//	INSERT INTO personne (Nom, Prenom, Email, Tel_domicile, Tel_mobile) VALUES (?, ?, ?, ?, ?);
//	/*Récupération de son ID_personne générer par auto_increment*/
//	SELECT ID_personne FROM personne WHERE Nom = ? AND Prenom = ? AND Email = ?;
//	/*Création du profil contact à l'aide de l'ID_personne précédemment récupéré*/
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
