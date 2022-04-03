package DonutsAndCoffee;

import java.util.ArrayList;

import application.Constants;

public class CakeDonuts extends MenuItem {
	protected String type = "Cake";
	protected ArrayList<DonutFlavors> flavor = new ArrayList<DonutFlavors>();
	//might have to put quantity field in here somewhere
	public CakeDonuts(String type, ArrayList<DonutFlavors> flavor) {
		super(type, flavor);
		this.donutType = type;
		this.Flavor = flavor;
		this.price = calculatePrice();	
	}
	
	public double calculatePrice() {
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
	
	public String getType() {
		return this.donutType;
	}
	
	/*
	public void updateQuantity() 
	*/
	
	public String toString() {
		String string = "";
		string += type + ":" + ":Flavor" + flavor.toString() + ":Price[" + String.valueOf(price) + "]";
		return string;
	}
}
