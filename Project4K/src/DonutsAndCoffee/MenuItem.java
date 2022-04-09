package DonutsAndCoffee;

import java.text.DecimalFormat;

/**
 * This class holds the properties of an Object representing a Menu Item.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class MenuItem {

	/**
	 * Creates price Object of type double.
	 */
    private double price;
    
    /**
     * Creates quantity Object of type int.
     */
    private int quantity;

    /**
     * The default constructor for an instance of the menu item class.
     */
    public MenuItem() {
    }

    /**
     * An overloaded constructor for an instance of the menu item class.
     *
     * @param itemPrice Object of type int.
     * @param quantity Object of type double.
     */
    public MenuItem(int quantity, double itemPrice) {
        this.price = itemPrice;
        this.quantity = quantity;
    }

    /**
     * This method calculates and returns the price of the item
     *
     * @return price, a double containing the price of the item
     */
    public double itemPrice() {
        return this.price * this.quantity;
    }

    /**
     * This method sets the price of a menu item object.
     *
     * @param number Object of type double.
     */
    public void setPrice(double number) {
        this.price = number;
    }

    /**
     * This method fetches the price of a menu item object.
     *
     * @return price is the price of the Object.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * This method sets the quantity of a Menu Item object.
     *
     * @param number Object of type int.
     */
    public void setQuantity(int number) {
        this.quantity = number;
    }

    /**
     * This method fetches the quantity of a menu item object.
     *
     * @return quantity is the quantity of the object.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * This method increments the quantity of a Menu Item Object.
     *
     * @param number Object of type int.
     */
    public void incrementQuantity(int number) {
        this.quantity += number;
    }

    /**
     * This uses the DecimalFormat class to format into dollar format.
     *
     * @param price Object of type double.
     * @return a String representation of the formatted price.
     */
    public static String formatPrice(double price) {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        String formattedPay = df.format(price);
        return formattedPay;
    }
}
