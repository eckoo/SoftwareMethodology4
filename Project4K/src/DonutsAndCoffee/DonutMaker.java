package DonutsAndCoffee;

import java.util.ArrayList;

import application.Constants;

public class DonutMaker {
	
	/**
	 * createDonut creates the current donut.
	 * @param donutType Object type String.
	 * @param size Object of type Size.
	 * @param flavor Object of type ArrayList<DonutFlavors>
	 * @param quantity Object of type int.
	 * @return current donut
	 */
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
