package DonutsAndCoffee;

import java.util.ArrayList;
import application.Constants;

public class CoffeeMaker {
	
	/**
	 * createCofee creates the current order's coffee.
	 * @param size Object of type Size.
	 * @param addins Object of type ArrayList<CoffeeAddIns>
	 * @return current coffee object.
	 */
	public static Coffee createCoffee(Size size, ArrayList<CoffeeAddIns> addins) {
		Coffee coffee = null;
		if(size.equals(Constants.SHORT)) {
			coffee = new Coffee(size, addins);
		}
		else if(size.equals(Constants.TALL)) {
			coffee = new Coffee(size, addins);
		}
		else if(size.equals(Constants.GRANDE)) {
			coffee = new Coffee(size, addins);
		}
		else if(size.equals(Constants.VENTI)) {
			coffee = new Coffee(size, addins);
		}
		return coffee;
	}
}
