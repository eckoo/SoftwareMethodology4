package DonutsAndCoffee;

import java.util.ArrayList;

import application.Constants;

public class Order implements Customizable {
	
	/**
	 * Creates phoneNumber Object of type String to identify customer.
	 */
	protected String phoneNumber; //not really any documentation in project doc as to how we identify the customer, 
								// so lets use a phone number
	/**
	 * Creates coffeeOrder Object of type ArrayList<Coffee>.
	 */
	protected ArrayList<Coffee> coffeeOrder = new ArrayList<Coffee>();
	
	/**
	 * Creates donutsOrder Object of type ArrayList<Donuts>.
	 */
	protected ArrayList<Donuts> donutsOrder = new ArrayList<Donuts>();
	
	/**
	 * Creates order Object of type ArrayList<MenuItem>.
	 */
	protected ArrayList<MenuItem> order = new ArrayList<MenuItem>();
	
	/**
	 * Creates totalPrice Object of type double.
	 */
	protected double totalPrice;
	
	/**
	 * Constructor class for the Order method.
	 * @param phone_number Object of type String.
	 */
	public Order(String phone_number) {
		this.phoneNumber = phone_number;
		this.totalPrice = 0;
	}
	
	/**
	 * CalculatePrice calculates the price of the order based on the contents.
	 * @return the current price of the order, including sales tax.
	 */
	private double CalculatePrice() {
		double currentPrice = 0;
		for(Coffee c : coffeeOrder) {
			currentPrice += c.price;
		}
		for(Donuts d : donutsOrder) {
			currentPrice += d.price;
		}
		currentPrice += currentPrice * Constants.SALES_TAX;
		String updatedPrice = String.format("%,.2f", currentPrice);
		totalPrice = Double.parseDouble(updatedPrice);
		return totalPrice;
	}
	
	/**
	 * This is the method for getting the current price of the order.
	 * @return CalculatePrice method.
	 */
	public double getPrice() {
		return CalculatePrice();
	}
	
	/**
	 * This is the method for getting the current size of the order (# of Objects)
	 * @return current order size.
	 */
	public int getSize() {
		return order.size();
	}
	
	/**
	 * This returns the coffee order itself.
	 * @return the current order.
	 */
	public ArrayList<Coffee> getCoffeeOrder() {
		return this.coffeeOrder;
	}
	
	/**
	 * This reutnrs the donuts order itself.
	 * @return the current order.
	 */
	public ArrayList<Donuts> getDonutsOrder() {
		return this.donutsOrder;
	}
	
	/**
	 * This is the method for adding 
	 * @param obj Object of type Object.
	 */
	@Override
	public boolean add(Object obj) {
		
		return false;
	}

	/**
	 * This is the method for removing 
	 * @param obj Object of type Object.
	 */
	@Override
	public boolean remove(Object obj) {
		
		return false;
	}

}
