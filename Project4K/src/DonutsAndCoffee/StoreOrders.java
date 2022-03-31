package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StoreOrders implements Customizable {
	private ArrayList<Order> ordersList = new ArrayList<Order>();
	
	/**
	 * getOrders returns the current order list.
	 * @return The order list.
	 */
	public ArrayList<Order> getOrders() {
		return this.ordersList;
	}
		
	/**
	 * 
	 * @param order
	 */
	public void addOrder(Order order) {
		ordersList.add(order);
	}

	/**
	 * 
	 * @param order
	 */
	public void completeOrder(Order order) {
		ordersList.remove(order);
	}
	
	/**
	 * getOrder returns the order at the current index.
	 * @param index Object of type int
	 * @return the current order at the given index.
	 */
	public Order getOrder(int index) {
		return ordersList.get(index);
	}
	
	/**
	 * exportTXT() exports all current store orders to .txt file.
	 * @return String representation of message exported from .txt file.
	 */
	public String exportTXT() {
		String path = "../Project4K/src/ExportedFiles";
		File newOutputFile = new File(path + "storeorders.txt");
		try {
			FileWriter output = new FileWriter(newOutputFile);
			for(Order jindex: ordersList) {
				output.write(jindex.toString() + "\n");
			}
			return "Order list exported.";
		}
		catch(IOException exception) {
			return "Exception caught.";
		}
	}

	@Override
	public boolean add(Object obj) {
		
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
