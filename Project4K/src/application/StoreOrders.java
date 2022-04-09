package application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import DonutsAndCoffee.Customizable;
import DonutsAndCoffee.Order;

/**
 * This class provides the functionality of managing multiple orders as well as
 * some other features.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class StoreOrders implements Customizable {

	/**
	 * Creates storedOrders Object of type Order Array List.
	 */
    private ArrayList<Order> storedOrders;

    /**
     * The default constructor of the StoreOrders class.
     */
    public StoreOrders() {
        storedOrders = new ArrayList<Order>();
    }

    /**
     * This method fetches the size of the list.
     *
     * @return the size of the list as an integer.
     */
    public int getSize() {
        return this.storedOrders.size();
    }

    /**
     * This method fetches the Order at the given index.
     *
     * @param index Object of type int.
     * @return the order
     */
    public Order getOrder(int index) {
        return this.storedOrders.get(index);
    }

    /**
     * This function adds an object to the list.
     *
     * @param obj Object of type Object.
     * @return true if an object is added, false if otherwise.
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Order) {
            Order order = (Order) obj;
            this.storedOrders.add(order);
            return true;
        }
        return false;
    }

    /**
     * This function removes an object from the list.
     *
     * @param obj Object of type Object.
     * @return true if an object is removed, false if otherwise.
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Order) {
            Order order = (Order) obj;
            this.storedOrders.remove(order);
            return true;
        }
        return false;
    }

    /**
     * toString returns a string representation of the current order.
     *
     * @return currString is a String containing all orders of the list.
     */
    @Override
    public String toString() {
        if (this.storedOrders.isEmpty()) {
            return null;
        }

        String currString = "";
        for (int i = 0; i < this.storedOrders.size(); i++) {
            currString = currString + this.storedOrders.get(i).toString() + "\n";
        }
        return currString;
    }

    /**
     * This function exports all the orders in the list as a txt file.
     */
    public void exportDatabase() {
        try {
            FileWriter writer = new FileWriter("storeOrders.txt");
            writer.write(this.toString());
            writer.close();
        } catch (IOException e) {

        }
    }
}
