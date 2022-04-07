package DonutsAndCoffee;

import java.util.ArrayList;
import application.Constants;

public class Donuts extends MenuItem implements Customizable {

	/**
	 * Creates price Object of type double.
	 */
	protected double price;
	
	/**
	 * Creates donutsOrder Object of type ArrayList<Donuts>.
	 */
	protected ArrayList<Donuts> donutsOrder = new ArrayList<Donuts>();
	
	/**
	 * Creates size Object of type Size.
	 */
	protected Size size;
	
	/**
	 * Creates itemType Object of type String, denotes as Donut.
	 */
	protected String itemType = "Donut";
	
	/**
	 * Creates flavor Object of type String.
	 */
	protected String flavor;
	
	/**
	 * Creates quantity Object of type int.
	 */
	protected int quantity;
	
	/**
	 * Donuts constructor.
	 * @param type Object of type String.
	 * @param itemType Object of type String.
	 * @param donutsOrder Object of type ArrayList<Donuts>
	 * @param flavor Object of type ArrayList<DonutFlavors>
	 * @param quantity Object of type int
	 */
	public Donuts(String type, String itemType, ArrayList<Donuts> donutsOrder, ArrayList<DonutFlavors> flavor, int quantity) {
		super(type, itemType, donutsOrder, flavor, quantity);
		this.donutType = type;
		this.Flavor = flavor;
		this.quantity = quantity;
		this.itemType = itemType;
		this.donutsOrder = donutsOrder;
	}
	
	/**
	 * This is the method for adding a donut to an order.
	 * @param obj Object of type Object.
	 */
	@Override
	public boolean add(Object obj) {
		if(obj instanceof Donuts) {
			donutsOrder.add((Donuts) obj);
		}
		return false;
	}

	/**
	 * This is the method for removing a donut from an order.
	 * @param obj Object of type Object.
	 */
	@Override
	public boolean remove(Object obj) {
		if(obj instanceof Donuts) {
			donutsOrder.remove((Donuts) obj);
		}
		return false;
	}
	
	

}
