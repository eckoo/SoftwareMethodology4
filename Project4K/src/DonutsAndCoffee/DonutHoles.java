package DonutsAndCoffee;

import java.util.ArrayList;

import application.Constants;

public class DonutHoles extends MenuItem {
	
	/**
	 * 
	 */
	protected String type = "hole";
	
	/**
	 * 
	 */
	protected ArrayList<DonutFlavors> flavor = new ArrayList<DonutFlavors>();
	
	protected int quantity;

	/**
	 * 
	 * @param type
	 * @param flavor
	 */
	public DonutHoles(String type, ArrayList<DonutFlavors> flavor, int quantity) {
		super(type, flavor, quantity);
		this.donutType = type;
		this.Flavor = flavor;
		this.price = calculatePrice();
	}
	
	/**
	 * 
	 * @return
	 */
	public double calculatePrice() {
		double price = Constants.baseDonutHolePrice;
		price = price * quantity;
		String output = String.format("%,.2f", price);
		price = Double.parseDouble(output);
		return price;
	}
	
	/**
	 * 
	 * @return
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
	 * 
	 * @return
	 */
	public String getType() {
		return this.donutType;
	}
	
	/**
	 * 
	 */
	public String toString() {
		String string = "";
		string += type + ":" + ":Flavor" + flavor.toString() + ":Price[" + String.valueOf(price) + "]";
		return string;
	}
}
