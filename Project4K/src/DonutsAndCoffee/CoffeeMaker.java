package DonutsAndCoffee;

import java.util.ArrayList;
import application.Constants;

public class CoffeeMaker {
	
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
