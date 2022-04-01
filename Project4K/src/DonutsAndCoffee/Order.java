package DonutsAndCoffee;

import java.util.ArrayList;

import application.Constants;

public class Order implements Customizable {
	private String phoneNumber; //not really any documentation in project doc as to how we identify the customer, 
								// so lets use a phone number
	private ArrayList<Coffee> order = new ArrayList<Coffee>();
	private double totalPrice;
	
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
		for(Coffee c : order) {
			currentPrice += c.price;
		}
		currentPrice += currentPrice * Constants.SALES_TAX;
		String updatedPrice = String.format("%,.2f", currentPrice);
		currentPrice = Double.parseDouble(updatedPrice);
		return currentPrice;
	}
	
	/**
	 * This is the method for adding a coffee to an order.
	 * @param coffee Object of type Coffee.
	 */
	public void addCoffee(Coffee coffee) {
		order.add(coffee);
	}
	
	/**
	 * This is the method for removing coffee from an order.
	 * @param coffee Object of type Coffee.
	 */
	public void removeCoffee(Coffee coffee) {
		order.remove(coffee);
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
	 * This returns the order itself.
	 * @return the current order.
	 */
	public ArrayList<Coffee> getOrder() {
		return this.order;
	}
	
	
	
	/**
	 * Not quite sure what to do with the interface methods below.
	 */
	
	
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
