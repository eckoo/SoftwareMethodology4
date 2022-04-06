package DonutsAndCoffee;

import java.util.ArrayList;

public class MenuItem {
	protected ArrayList<CoffeeAddIns> AddIns = new ArrayList<CoffeeAddIns>();
	protected ArrayList<DonutFlavors> Flavor = new ArrayList<DonutFlavors>();
	protected String donutType;
	protected String itemType;
	protected Size size;
	protected double price;
	protected int quantity;
	
	public double itemPrice() {
		return price;
	}
	
	
	public MenuItem(String itemType) {
		this.itemType = itemType;
	}

	public MenuItem(Size SIZE, ArrayList<CoffeeAddIns> ADDINS) {
		//return coffee order with size and addins
		this.size = SIZE;
		this.AddIns = ADDINS;
	}


	public MenuItem(String type, ArrayList<DonutFlavors> flavor) {
		// TODO Auto-generated constructor stub
		this.donutType = type;
		this.Flavor = flavor;
	}


	public MenuItem(String type, ArrayList<DonutFlavors> flavor, int quantity) {
		// TODO Auto-generated constructor stub
		this.donutType = type;
		this.Flavor = flavor;
		this.quantity = quantity;
	}


	public String getItemType() {
		return itemType;
	}
	
	
	public void updateSize(Size size) {
		this.size = size;
	}
	
	public Size getSize() {
		return size;
	}
	
	public void updateAddIns(ArrayList<CoffeeAddIns> addins) {
		this.AddIns = addins;
	}
	
	
}
