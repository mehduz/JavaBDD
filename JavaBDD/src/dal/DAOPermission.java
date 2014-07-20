package dal;

public enum DAOPermission {
	
	ELEVE(1),
	PROF(2),
	ADMIN(3);
	
	private final int value;
	
	private DAOPermission(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	private static DAOPermission[] values = null;
	
    public static DAOPermission fromInt(int i) {
        if(DAOPermission.values == null) {
        	DAOPermission.values = DAOPermission.values();
        }
        return DAOPermission.values[i];
    }
}

