package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import javafx.scene.control.ComboBox;

/**
 * A controller class that provides the functionality to manage multiple orders
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class StoreOrdersController implements Initializable{

	/**
	 * Creates cbOrderNumber FXML Object of type ComboBox Integer.
	 */
    @FXML
    private ComboBox<Integer> cbOrderNumber;
    
    /**
     * Creates txtTotal FXML Object of type TextField.
     */
    @FXML
    private TextField txtTotal;
    
    /**
     * Creates listView FXML Object of type TextArea.
     */
    @FXML
    private TextArea listView;

    /**
     * initialize() is called automatically. It gives the combo box its options.
     * @param location Object of type URL.
     * @param resources Object of type ResourceBundle.
     * 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int x = 0; x < Main.myStore.getSize(); x++) {
            this.cbOrderNumber.getItems().add(x + 1);
        }
        if (cbOrderNumber.getItems().isEmpty()) {
            return;
        }
        this.cbOrderNumber.setValue(1);

        this.update();
    }

    /**
     * update() is a helper function that is called several times through the
     * class. It changes the page to match any changes made by the user.
     */
    private void update() {
        if (cbOrderNumber.getItems().isEmpty()) {
            return;
        }
        int num = this.cbOrderNumber.getValue() - 1;

        this.listView.setText(Main.myStore.getOrder(num).toString());
        this.txtTotal.setText(Main.myStore.getOrder(num).getTotal());

    }

    /**
     * Clicking the export button calls this function. It exports all the orders
     * into a txt file.
     *
     * @param e Object of type ActionEvent.
     */
    @FXML
    private void exportOrder(ActionEvent e) {
    	if (Main.myStore.getSize() <= 0) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setContentText("You have no orders");
            alert.show();
            return;
        }
        Main.myStore.exportDatabase();
        Alert confirmation = new Alert(AlertType.INFORMATION);
        confirmation.setTitle("INFORMATION!");
        confirmation.setHeaderText("Information");
        confirmation.setContentText("Orders are exported!");
        confirmation.show();
    }

    /**
     * Switching through the combo box calls orderNumberChanged. It calls the update
     * helper function to dynamically shows the order on the textbox.
     *
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void orderNumberChanged(ActionEvent event) {
        update();
    }

    /**
     * cancelOrder is called when the cancel order button is clicked. It
     * removes the selected order from the list.
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void cancelOrder(ActionEvent event) {
    	try {
            int num = this.cbOrderNumber.getValue() - 1;
            this.cbOrderNumber.getItems().remove(Main.myStore.getSize() - 1);
            Main.myStore.remove(Main.myStore.getOrder(num));

            if (this.cbOrderNumber.getItems().isEmpty()) {
                this.listView.clear();
                this.txtTotal.clear();
            }

            this.update();
        } catch (Exception e) {
            Alert confirmation = new Alert(AlertType.WARNING);
            confirmation.setTitle("WARNING!");
            confirmation.setHeaderText("Warning");
            confirmation.setContentText("No order to cancel!");
            confirmation.show();
        }
    }
}
