package DonutsAndCoffee;

import java.util.ArrayList;

import application.Constants;

public class CakeDonuts extends MenuItem {
	
	/**
	 * Creates type Object to denote it is a cake donut.
	 */
	protected String type = "Cake";
	
	/**
	 * Created a flavor Object ArrayList of type DonutFlavors.
	 */
	protected ArrayList<DonutFlavors> flavor = new ArrayList<DonutFlavors>();
	
	/**
	 * 
	 * @param type
	 * @param flavor
	 * @param quantity
	 */
	public CakeDonuts(String type, ArrayList<DonutFlavors> flavor, int quantity) {
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
		double price = Constants.baseCakeDonutPrice;
		
		String output = String.format("%,.2f", price);
		price = Double.parseDouble(output);
		return price;
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
	 * getQuantity returns the amount of donuts ordered.
	 * @return this.quantity.
	 */
	public double updateQuantity() {
		return this.quantity;
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
