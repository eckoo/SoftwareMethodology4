package DonutsAndCoffee;

import java.util.ArrayList;
import application.Constants;

public class Donuts extends MenuItem implements Customizable {

	protected double price;
	protected Size size;
	protected String itemType = "Donut";
	protected String flavor;
	
	public Donuts(String itemType) {
		super(itemType);
		// TODO Auto-generated constructor stub
	}

	/*
	public Donuts(String donutType, Size size2, ArrayList<DonutFlavors> flavor2) {
		// TODO Auto-generated constructor stub
	}
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
