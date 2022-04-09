package application;

import java.net.URL;
import java.util.ResourceBundle;

import DonutsAndCoffee.MenuItem;
import DonutsAndCoffee.Order;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * This Controller class is for the current order menu and allows for storing
 * and manipulation of the user's order of Coffee and/or Donuts.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class YourOrderController implements Initializable {

	/**
	 * Creates txtSubTotal FXML Object of type TextField.
	 */
    @FXML
    private TextField txtSubTotal;
    
    /**
     * Creates txtSalesTax FXML Object of type TextField.
     */
    @FXML
    private TextField txtSalesTax;
    
    /**
     * Creates txtTotal FXML Object of type TextField.
     */
    @FXML
    private TextField txtTotal;
    
    /**
     * Creates listView Object of type ListView MenuItem.
     */
    @FXML
    private ListView<MenuItem> listView;

    /**
     * This method initializes the scene for the current order.
     * @param location Object of type URL.
     * @param resources Object of type ResourceBundle.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        update();
    }

    /**
     * This helper method updates the current page to match any changes made by the user.
     */
    private void update() {
        Main.myOrder.calculatePayment();
        this.listView.getItems().clear();
        listView.getItems().addAll(Main.myOrder.getItems());
        txtSubTotal.setText("" + Main.myOrder.getSubtotal());
        txtSalesTax.setText("" + Main.myOrder.getSalesTax());
        txtTotal.setText("" + Main.myOrder.getTotal());
    }

    /**
     * This method removes an Object from the current order.
     */
    @FXML
    private void removeItem() {
    	MenuItem selected = this.listView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Main.myOrder.remove(selected);
            update();
        }else{
            Alert confirmation = new Alert(AlertType.WARNING);
            confirmation.setTitle("WARNING!");
            confirmation.setHeaderText("Warning");
            confirmation.setContentText("Please pick an item!");
            confirmation.show();
        }
    }

    /**
     * This method adds the current order to store orders and is triggered when
     * the user clicks the place order button.
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void placeOrder(ActionEvent event) {
        if (Main.myOrder.isEmpty()) {
            Alert confirmation = new Alert(AlertType.WARNING);
            confirmation.setTitle("WARNING!");
            confirmation.setHeaderText("Warning");
            confirmation.setContentText("You have an empty order. Please select some donuts and coffee :)");
            confirmation.show();
            return;
        }

        if (Main.myOrder != null) {

            Alert confirmation = new Alert(AlertType.INFORMATION);
            confirmation.setTitle("Confirmation");
            confirmation.setHeaderText("Confirmation");
            confirmation.setContentText("Order has been placed");
            confirmation.show();

            Main.myStore.add(Main.myOrder);
            Main.myOrder = new Order();

        }
        update();
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }
}
