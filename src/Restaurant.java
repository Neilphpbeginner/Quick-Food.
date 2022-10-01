import java.util.ArrayList;

public class Restaurant {

	private String restaurantName;
	private String restaurantLocation;
	private String restaurantContactDetails;
	private ArrayList<Meal> meals = new ArrayList<Meal>();

	public Restaurant(String restaurantName, String restaurantLocation, String restaurantContactDetails) {
		this.restaurantName = restaurantName;
		this.restaurantLocation = restaurantLocation;
		this.restaurantContactDetails = restaurantContactDetails;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public String getRestaurantLocation() {
		return restaurantLocation;
	}

	public String getRestaurantContactDetails() {
		return restaurantContactDetails;
	}

	public void addmeals(String mealDescription, double mealPrice) {
		Meal newMenuItem = new Meal(mealDescription, mealPrice);
		this.meals.add(newMenuItem);
	}

	public ArrayList<Meal> getMeals() {
		return meals;
	}

}
