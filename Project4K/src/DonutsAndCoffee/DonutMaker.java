package DonutsAndCoffee;

import java.util.ArrayList;

import application.Constants;

public class DonutMaker {
	
	public static Donuts createDonut(String donutType, Size size, ArrayList<DonutFlavors> flavor, int quantity) {
		MenuItem donut = null;

		if(donutType.equals(Constants.YEAST)) {
			donut = new YeastDonuts(Constants.YEAST, flavor, quantity);
		}
		else if(donutType.equals(Constants.CAKE)) {
			donut = new CakeDonuts(Constants.CAKE, flavor, quantity);
		}
		else if(donutType.equals(Constants.HOLE)) {
			donut = new DonutHoles(Constants.HOLE, flavor, quantity);
		}
		return (Donuts) donut;
	}
}
