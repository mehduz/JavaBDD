package Test;
import static org.junit.Assert.*;

import org.junit.Test;

import beans.Eleve;
import dal.DAOFactory;
import dal.daoImpl.EleveDaoImpl;


public class TestDB {

	@Test
	public void test() {
		
		EleveDaoImpl el = new EleveDaoImpl(new DAOFactory());
		Eleve eleve = el.trouver("Romain", "5026bc63b5418ffdb54f238db245ec01");

		System.out.println(eleve.getCode_postal());
		
		fail("Not yet implemented");
	}

}
