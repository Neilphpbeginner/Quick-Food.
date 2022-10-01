
public class Meal {
	private String mealDescription;
	private double mealCost;
	private int qty;

	public Meal(String mealDescription, double mealCost) {
		this.mealDescription = mealDescription;
		this.mealCost = mealCost;
	}

	public String getMealDescription() {
		return mealDescription;
	}

	public double getMealCost() {
		return mealCost;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getQty() {
		return qty;
	}

}
