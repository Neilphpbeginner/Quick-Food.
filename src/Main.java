import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Driver> drivers = new ArrayList<Driver>();

	public static void getDrivers() {
		File driverInformation = new File("./src/drivers.txt");

		try {

			Scanner scanner = new Scanner(driverInformation);

			while (scanner.hasNextLine()) {
				String[] driverData = scanner.nextLine().split(",");
				String driverName = driverData[0].strip();
				String driverLocation = driverData[1].strip();
				if (driverData[2].strip() == "") {
					Driver driver = new Driver(driverName, driverLocation, 0);
					drivers.add(driver);
				} else {
					Driver driver = new Driver(driverName, driverLocation, Integer.parseInt(driverData[2].strip()));
					drivers.add(driver);

				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

	public static String checkNeareastDriver(Order order) {
		ArrayList<Integer> workLoadCheck = new ArrayList<Integer>();

		for (int i = 0; i < drivers.size(); i++) {
			if (order.getCustomerRestuarant().getRestaurantLocation().equals(drivers.get(i).getDriverLocation())) {
				workLoadCheck.add(drivers.get(i).getWorkLoad());
			}
		}

		int minimumWorkload = workLoadCheck.stream().min(Integer::compare).get();

		for (int i = 0; i < drivers.size(); i++) {
			if (drivers.get(i).getWorkLoad() == minimumWorkload && order.getCustomerRestuarant().getRestaurantLocation()
					.equals(drivers.get(i).getDriverLocation())) {
				return (drivers.get(i).getDriverName());
			}
		}

		return "";

	}

	public static void main(String[] args) throws FileNotFoundException {

		getDrivers();
		Customer testCase = new Customer("Neil", "0123456789", "12 Cherry Road", "Cape Town", "test@test.com");
		Restaurant aesopPizza = new Restaurant("Aesop’s Pizza", "Cape Town", "098 765 4321");
		aesopPizza.addmeals("Pepperoni pizza", 78.00);
		aesopPizza.addmeals("Hawaiian pizza", 82.00);
		boolean driverLocationCheck = drivers.stream()
				.anyMatch(driver -> driver.getDriverLocation().equals(testCase.getCustomerLocation()));

		Order orderOne = new Order(testCase, aesopPizza);
		orderOne.setMenuItemQty("Pepperoni pizza", 1);
		orderOne.setMenuItemQty("Hawaiian pizza", 2);
		orderOne.addSpecialInsttuctions("Extra tomato base on the Pepperoni pizza");
		String deliveryDriver = checkNeareastDriver(orderOne);
		orderOne.setDriver(deliveryDriver);

		try {

			FileWriter generateInvoice = new FileWriter("./src/invoice.txt");
			if (driverLocationCheck) {
				generateInvoice.write(orderOne.generateInvoice());
				generateInvoice.close();
			} else {
				generateInvoice
						.write("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
				generateInvoice.close();
			}
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
