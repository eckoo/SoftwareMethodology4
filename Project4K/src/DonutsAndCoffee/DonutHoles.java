package DonutsAndCoffee;

import java.util.ArrayList;

import application.Constants;

public class DonutHoles extends MenuItem {
	
	/**
	 * Defines donut type as donut hole.
	 */
	protected String type = "hole";
	
	/**
	 * Created a flavor Object ArrayList of type DonutFlavors.
	 */
	protected ArrayList<DonutFlavors> flavor = new ArrayList<DonutFlavors>();
	
	/**
	 * Creates a quantity Object of type int.
	 */
	protected int quantity;

	/**
	 * DonutHoles constructor.
	 * @param type Object of type String.
	 * @param flavor Object of type ArrayList<DonutFlavors>
	 * @param quantity Object of type int.
	 */
	public DonutHoles(String type, ArrayList<DonutFlavors> flavor, int quantity) {
		super(type, flavor, quantity);
		this.donutType = type;
		this.Flavor = flavor;
		this.price = itemPrice();
	}
	
	/**
	 * itemPrice calculates current item price.
	 * @return price Object of type double.
	 */
	public double itemPrice() {
		double price = Constants.baseDonutHolePrice;
		price = price * quantity;
		String output = String.format("%,.2f", price);
		price = Double.parseDouble(output);
		return price;
	}
	
	/**
	 * getQuantity returns the amount of donuts ordered.
	 * @return this.quantity.
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * updateFlavor returns the flavor chosen of the current donut.
	 * @param flavor Object of type DonutFlavors.
	 */
	public void updateFlavor(ArrayList<DonutFlavors> flavor) {
		this.Flavor = flavor;
	}
	
	/**
	 * Constructor method.
	 * @return this.donutType
	 */
	public String getType() {
		return this.donutType;
	}
	
	/**
	 * Returns string representation of order.
	 * @return String Object of type String.
	 */
	public String toString() {
		String string = "";
		string += type + ":" + ":Flavor" + flavor.toString() + ":Price[" + String.valueOf(price) + "]";
		return string;
	}
}
