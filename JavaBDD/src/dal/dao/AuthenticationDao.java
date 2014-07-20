package dal.dao;

import beans.Authentication;

public interface AuthenticationDao {
	
	Authentication trouver(String login, String mdp);

}
