package dal;

public enum DAOPermission {
	
	ELEVE,
	PROF,
	ADMIN;
	
	private static DAOPermission[] values = null;
	
    public static DAOPermission fromInt(int i) {
        if(DAOPermission.values == null) {
        	DAOPermission.values = DAOPermission.values();
        }
        return DAOPermission.values[i-1];
    }
}

