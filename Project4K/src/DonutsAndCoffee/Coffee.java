package DonutsAndCoffee;

import java.util.ArrayList;
import application.Constants;

public class Coffee extends MenuItem implements Customizable {
	protected ArrayList<CoffeeAddIns> addins = new ArrayList<CoffeeAddIns>();
	protected double price;
	protected Size size;

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
