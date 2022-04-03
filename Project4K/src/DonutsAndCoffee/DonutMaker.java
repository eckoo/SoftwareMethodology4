package DonutsAndCoffee;

import java.util.ArrayList;

import application.Constants;

//this might turn into DonutMaker instead
public class DonutMaker {
	
	public static Donuts createDonut(String donutType, Size size, ArrayList<DonutFlavors> flavor) {
		Donuts donut = null;
		if(donutType.equals(Constants.YEAST)) {
			donut = new YeastDonuts(size, flavor);
		}
	}
}
