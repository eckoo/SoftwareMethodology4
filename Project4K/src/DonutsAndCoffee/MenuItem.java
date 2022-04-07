package DonutsAndCoffee;

import java.util.ArrayList;

public class MenuItem {
	/**
	 * Creates an AddIns Object of type ArrayList<CoffeeAddIns>.
	 */
	protected ArrayList<CoffeeAddIns> AddIns = new ArrayList<CoffeeAddIns>();
	
	/**
	 * Creates Flavor Object of type ArrayList<DonutFlavors>.
	 */
	protected ArrayList<DonutFlavors> Flavor = new ArrayList<DonutFlavors>();
	
	/**
	 * Creates order Object of type ArrayList<Coffee>.
	 */
	protected ArrayList<Coffee> coffeeOrder = new ArrayList<Coffee>();
	
	/**
	 * 
	 */
	protected ArrayList<Donuts> donutsOrder = new ArrayList<Donuts>();
	
	/**
	 * Creates donutType Object of type String.
	 */
	protected String donutType;
	
	/**
	 * Creates itemType Object of type String.
	 */
	protected String itemType;
	
	/**
	 * Creates size Object of type Size.
	 */
	protected Size size;
	
	/**
	 * Creates price Object of type double.
	 */
	protected double price;
	
	/**
	 * Creates quantity Object of type int.
	 */
	protected int quantity;
	
	/**
	 * itemPrice is a constructor method that returns the current order's price.
	 * @return price Object of type double.
	 */
	public double itemPrice() {
		return price;
	}
	
	/**
	 * MenuItem is a constructor method.
	 * @param itemType Object of type String.
	 */
	public MenuItem(String itemType) {
		this.itemType = itemType;
	}

	/**
	 * MenuItem is also a constructor method.
	 * @param itemType 
	 * @param SIZE Object of type Size
	 * @param ADDINS Object of type 
	 */
	public MenuItem(Size size, ArrayList<CoffeeAddIns> AddIns, String itemType, ArrayList<Coffee> order) {
		//return coffee order with size and addins
		this.size = size;
		this.AddIns = AddIns;
		this.itemType = itemType;
		this.coffeeOrder = order;
	}

	public MenuItem(String type, String itemType, ArrayList<Donuts> donutsOrder, ArrayList<DonutFlavors> flavor, int quantity) {
		this.donutType = type;
		this.Flavor = flavor;
		this.quantity = quantity;
		this.itemType = itemType;
		this.donutsOrder = donutsOrder;
	}

	public MenuItem(Size size, ArrayList<CoffeeAddIns> addins) {
		this.size = size;
		this.AddIns = addins;
	}

	/**
	 * getItemType returns the current item's type.
	 * @return itemType Object of type String.
	 */
	public String getItemType() {
		return itemType;
	}
	
	/**
	 * updateSize is a constructor method that updates current order size.
	 * @param size Object of type Size.
	 */
	public void updateSize(Size size) {
		this.size = size;
	}
	
	/**
	 * getSize is a constructor method that returns the current size.
	 * @return size Object of type Size.
	 */
	public Size getSize() {
		return size;
	}
	
	/**
	 * updateAddIns is a constructor method that updates the current addins in the coffee.
	 * @param addins Object of type ArrayList<CoffeeAddIns>
	 */
	public void updateAddIns(ArrayList<CoffeeAddIns> addins) {
		this.AddIns = addins;
	}
	
	
}
