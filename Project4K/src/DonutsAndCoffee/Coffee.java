package DonutsAndCoffee;

import java.util.ArrayList;
import application.Constants;

public class Coffee extends MenuItem implements Customizable {

	/**
	 * Creates addins Object of type ArrayList<CoffeeAddIns>
	 */
	protected ArrayList<CoffeeAddIns> addins = new ArrayList<CoffeeAddIns>();
	
	/**
	 * Creates order Object of type Coffee.
	 */
	protected ArrayList<Coffee> order = new ArrayList<Coffee>();
	
	/**
	 * Creates price Object of type double.
	 */
	protected double price;
	
	/**
	 * Creates size Object of type Size.
	 */
	protected Size size;
	
	/**
	 * Creates itemType Object to denote it is a coffee.
	 */
	protected String itemType = "Coffee";
	
	/**
	 * Coffee constructor.
	 * @param size Object of type Size.
	 * @param addins Object of type ArrayList<CoffeeAddIns>
	 * @param itemType Object of type String.
	 * @param order Object of type ArrayList<Coffee>
	 */
	public Coffee(Size size, ArrayList<CoffeeAddIns> addins, String itemType, ArrayList<Coffee> order) {
		super(size, addins, itemType, order);
		this.size = size;
		this.AddIns = addins;
		this.price = itemPrice();
		this.order = order;
		
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Coffee constructor method.
	 * @param size Object of type size.
	 * @param addins Object of type ArrayList<CoffeeAddIns>
	 */
	public Coffee(Size size, ArrayList<CoffeeAddIns> addins) {
		super(size, addins);
		this.size = size;
		this.addins = addins;
	}

	/**
	 * itemPrice calculates the current price.
	 * @return price Object of type double.
	 */
	@Override
	public double itemPrice() {
		double price = Constants.baseCoffeePrice;
		if(size.name().equals(Constants.SHORT.toUpperCase())) {
			price += 0;
		}
		else if(size.name().equals(Constants.TALL.toUpperCase())) {
			price += Constants.tallSizePriceIncrease;
		}
		else if(size.name().equals(Constants.GRANDE.toUpperCase())) {
			price += Constants.grandeSizePriceIncrease;
			
		}
		else if(size.name().equals(Constants.VENTI.toUpperCase())) {
			price += Constants.ventiSizePriceIncrease;
		}
		String out = String.format("%,.2f", price);
		price = Double.parseDouble(out);
		return price;
	}
	
	/**
	 * updateAddIns is a constructor method to update addins.
	 */
	public void updateAddIns(ArrayList<CoffeeAddIns> addins) {
		this.AddIns = addins; 
		this.price = itemPrice();
	}
	
	/**
	 * getAddIns returns the current addins.
	 * @return current list of AddIns.
	 */
	public ArrayList<CoffeeAddIns> getAddIns() {
		return this.AddIns;
	}
	
	/**
	 * getSize constructor method.
	 * @return the current size.
	 */
	public Size getSize() {
		return this.size;
	}
	
	/**
	 * toString returns a string representation of the current order.
	 * @return output Object of type String.
	 */
	public String toString() {
		String output = "";
		output += itemType + ":" + size.name() + ":Add-Ins" + addins.toString() + ":Price[" + String.valueOf(price) + "]";
		return output;
	}


	/**
	 * This is the method for adding a coffee to an order.
	 * @param obj Object of type Object.
	 */
	@Override
	public boolean add(Object obj) {
		if(obj instanceof Coffee) {
			order.add((Coffee) obj);
		}
		return false;
	}

	/**
	 * This is the method for removing coffee from an order.
	 * @param obj Object of type Object.
	 */
	@Override
	public boolean remove(Object obj) {
		if(obj instanceof Coffee) {
			order.remove((Coffee) obj);
		}
		return false;
	}
	
	

}
