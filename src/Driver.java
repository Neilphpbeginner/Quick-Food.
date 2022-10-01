
public class Driver {

	private String driverName;
	private String driverLocation;
	private int workLoad;

	public Driver(String driverName, String driverLocation, int workLoad) {
		this.driverName = driverName;
		this.driverLocation = driverLocation;
		this.workLoad = workLoad;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getDriverLocation() {
		return driverLocation;
	}

	public int getWorkLoad() {
		return workLoad;
	}

}
