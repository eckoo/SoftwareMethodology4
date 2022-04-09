package DonutsAndCoffee;

import java.util.ArrayList;

/**
 * This class provides the functionality of an Order.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class Order implements Customizable {

	/**
	 * Creates NJTAX Object of type double.
	 */
    private final static double NJTAX = .06625;

    /**
     * Creates items Object of type ArrayList MenuItem.
     */
    private ArrayList<MenuItem> items;
    
    /**
     * Creates subtotal Object of type double.
     */
    private double subtotal;
    
    /**
     * Creates total Object of type double.
     */
    private double total;
    
    /**
     * Creates salesTax Object of type double.
     */
    private double salesTax; 

    /**
     * The default constructor of the Order class.
     */
    public Order() {
        items = new ArrayList<MenuItem>();
    }

    /**
     * This function calculates the subtotal, sales tax, and total cost of all
     * the items in the order.
     */
    public void calculatePayment() {
        this.subtotal = 0;
        for (int i = 0; i < items.size(); i++) {
            this.subtotal += items.get(i).itemPrice();
        }

        salesTax = subtotal * NJTAX;
        total = salesTax + subtotal;
    }

    /**
     * This function returns all items
     *
     * @return items Object of type ArrayList MenuItem.
     */
    public ArrayList<MenuItem> getItems() {
        return items;
    }

    /**
     * This function fetches the subtotal for this particular order in the
     * correct dollar format.
     *
     * @return a String of the subtotal in dollar format.
     */
    public String getSubtotal() {
        MenuItem item = new MenuItem();
        return item.formatPrice(this.subtotal);
    }

    /**
     * This function fetches the total for this particular order in the correct
     * dollar format.
     *
     * @return a String of the total in dollar format.
     */
    public String getTotal() {
        MenuItem item = new MenuItem();
        return item.formatPrice(this.total);

    }

    /**
     * This function fetches the sales tax for this particular order in the
     * correct dollar format.
     *
     * @return a String of the sales tax in dollar format.
     */
    public String getSalesTax() {
        MenuItem item = new MenuItem();
        return item.formatPrice(this.salesTax);
    }

    /**
     * This function checks whether the list of MenuItems is empty or not.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    /**
     * This function adds a MenuItem from the list,
     *
     * @param obj Object of type Object.
     * @return true if the item is added, false otherwise.
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof MenuItem) {
            MenuItem item = (MenuItem) obj;
            boolean inBag = false;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).equals(item)) {
                    items.get(i).incrementQuantity(item.getQuantity());
                    inBag = true;
                }
            }
            if (inBag == false) {
                items.add(item);
            }

            return true;
        }

        return false;
    }

    /**
     * This function removes a MenuItem from the list, if it is in the list.
     *
     * @param obj Object of type Object.
     * @return true if the item is removed, false otherwise.
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof MenuItem) {
            MenuItem item = (MenuItem) obj;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).equals(item)) {
                    items.remove(i);
                    return true;
                }
            }
        } else if (obj instanceof String) {
            String item = (String) obj;
            for (int x = 0; x < items.size(); x++) {
                if (items.get(x).toString().equals(item)) {
                    items.remove(x);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Compares this instance of the class to another object.
     *
     * @param obj Object of type Object.
     * @return true if the object is the same, false if otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Order) {
            Order newOrder = (Order) obj;
            if (this.toString().equals(newOrder.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * toString returns string representation of current item.
     * @return currString is a string that describes this instance of the class.
     */
    @Override
    public String toString() {
        String currString = "";
        for (int i = 0; i < items.size(); i++) {
            currString = currString + items.get(i).toString() + "\n";
        }
        return currString;
    }

}
