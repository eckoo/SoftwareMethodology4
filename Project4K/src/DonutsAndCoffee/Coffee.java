package DonutsAndCoffee;

import java.util.ArrayList;
import application.Constants;

public class Coffee extends MenuItem implements Customizable {

	protected ArrayList<CoffeeAddIns> addins = new ArrayList<CoffeeAddIns>();
	protected double price;
	protected Size size;
	protected String itemType = "Coffee";
	
	public Coffee(Size size, ArrayList<CoffeeAddIns> addins) {
		super(size, addins);
		this.size = size;
		this.AddIns = addins;
		this.price = calculatePrice();
		
		// TODO Auto-generated constructor stub
	}
	
	public double calculatePrice() {
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
	
	public void updateAddIns(ArrayList<CoffeeAddIns> addins) {
		this.AddIns = addins; 
		this.price = calculatePrice();
	}
	
	public ArrayList<CoffeeAddIns> getAddIns() {
		return this.AddIns;
	}
	
	public Size getSize() {
		return this.size;
	}
	
	public String toString() {
		String output = "";
		output += itemType + ":" + size.name() + ":Add-Ins" + addins.toString() + ":Price[" + String.valueOf(price) + "]";
		return output;
	}


	//not really too sure what to do with these
	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
