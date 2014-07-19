package dal.daoImpl;

import beans.Classe;
import dal.DAOException;
import dal.DAOFactory;
import dal.dao.ClasseDao;

public class ClasseDaoImpl extends SuperDaoImpl implements ClasseDao  {

	 private static final String SQL_SELECT_PAR_LOGIN_MDP = "SELECT ID_personne FROM Authentication WHERE Login = ? and MDP = ?";
	 private static final String SQL_INSERT_ELEVE = "INSERT INTO eleve (Date_naissance, Ville_naissance, Pays_naissance,Sexe,"+
			 "Date_inscription, Etablissement_prec, Photo, Rue,"+
			 "Code_postal, Ville, Email,Remarques_medicale, ID_personne, Nom_classe,"+
			 " ID_contact, ID_prof) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
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
