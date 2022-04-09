package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DonutsAndCoffee.Donut;
import DonutsAndCoffee.DonutTypes;
import DonutsAndCoffee.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * This controller class provides the functionality for ordering donuts.
 *
 * @author Kiernan King and Ahmed Alghazwi
 *
 */
public class OrderingDonutController implements Initializable {

	/**
	 * Creates donutList Object of type ArrayList Donut.
	 */
    private ArrayList<Donut> donutsList;

    /**
     * Creates cbDonutType FXML Object of type ComboBox String.
     */
    @FXML
    private ComboBox<String> cbDonutType;
    
    /**
     * Creates imgDonut FXML Object of type ImageView.
     */
    @FXML
    private ImageView imgDonut;
    
    /**
     * Creates lvDonutFlavor FXML Object of type ListView String.
     */
    @FXML
    private ListView<String> lvDonutFlavor;
    
    /**
     * Creates lvDonutOrder FXML Object of type ListView Donut.
     */
    @FXML
    private ListView<Donut> lvDonutOrder;
    
    /**
     * Creates cbQuantity FXML Object of type ComboBox Integer.
     */
    @FXML
    private ComboBox<Integer> cbQuantity;
    
    /**
     * Creates txtTotal FXML Object of type TextField.
     */
    @FXML
    private TextField txtTotal;

    /**
     * initialize() is called automatically. It gives the combo box its options.
     * @param location Object of type URL.
     * @param resources Object of type ResourceBundle.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            FileInputStream inputstream = new FileInputStream("Images/Yeast Donuts.png");
            Image image = new Image(inputstream);
            imgDonut.setImage(image);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        this.donutsList = new ArrayList<Donut>();
        this.cbDonutType.getItems().addAll("Yeast Donuts", "Cake Donuts", "Donut Holes");
        this.cbQuantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        this.cbQuantity.setValue(1);
        this.cbDonutType.setValue("Yeast Donuts");
        this.lvDonutFlavor.getItems().addAll(Donut.YEAST_FLAVORS);
    }

    /**
     * update() is a helper function that is called several times through the class.
     * It changes the page to match any changes made by the user.
     */
    private void update() {
        this.lvDonutOrder.getItems().clear();

        double subtotal = 0;

        for (int x = 0; x < this.donutsList.size(); x++) {
            this.lvDonutOrder.getItems().add(this.donutsList.get(x));
            subtotal += this.donutsList.get(x).itemPrice();
        }

        this.txtTotal.setText(MenuItem.formatPrice(subtotal));

    }

    /**
     * addToList() takes a selected item of a specific type and flavor into the list.
     */
    @FXML
    private void addToList() {
    	String typeS = this.cbDonutType.getValue();
        String flavor = this.lvDonutFlavor.getSelectionModel().getSelectedItem();
        if (flavor == null) {
            Alert confirmation = new Alert(AlertType.WARNING);
            confirmation.setTitle("WARNING!");
            confirmation.setHeaderText("Warning");
            confirmation.setContentText("Please pick a donut!");
            confirmation.show();
            return;
        }

        int quantity = this.cbQuantity.getValue();
        Donut myDonut = new Donut(quantity, DonutTypes.getValue(typeS), flavor);

        this.donutsList.add(myDonut);
        update();
    }

    /**
     * removeFromList() removes a selected item from the list.
     */
    @FXML
    private void removeFromList() {

        Donut selected = this.lvDonutOrder.getSelectionModel().getSelectedItem();
        if (selected != null) {
            this.donutsList.remove(selected);
            this.update();
        } else {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please select something to remove");
            alert.show();
        }
    }

    /**
     * addToOrder adds the selected items to the order.
     * @param e Object of type ActionEvent.
     */
    @FXML
    private void addToOrder(ActionEvent e) {
        if (donutsList.isEmpty()) {
            Alert confirmation = new Alert(AlertType.WARNING);
            confirmation.setTitle("WARNING!");
            confirmation.setHeaderText("Warning");
            confirmation.setContentText("Please pick a donut!");
            confirmation.show();
            return;
        }

        Alert confirmation = new Alert(AlertType.INFORMATION);
        confirmation.setTitle("Confirmation");
        confirmation.setHeaderText("Confirmation");
        confirmation.setContentText("Donut(s) have been added to Order");
        confirmation.show();

        for (int x = 0; x < this.donutsList.size(); x++) {
            Main.myOrder.add(this.donutsList.get(x));
        }
        ((Stage) ((Node) e.getSource()).getScene().getWindow()).close();
    }

    /**
     * typeChanges is called when the combobox is interacted with and updates
     * the selection to reflect what is available for the current donut type.
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void typeChanges(ActionEvent event) {
        lvDonutFlavor.getItems().clear();
        if ("Yeast Donuts".equals(cbDonutType.getValue())) {
            lvDonutFlavor.getItems().addAll(Donut.YEAST_FLAVORS);
        } else if ("Donut Holes".equals(cbDonutType.getValue())) {
            lvDonutFlavor.getItems().addAll(Donut.HOLE_FLAVORS);
        } else if ("Cake Donuts".equals(cbDonutType.getValue())) {
            lvDonutFlavor.getItems().addAll(Donut.CAKE_FLAVORS);
        }

        try {
            imgDonut.setImage(new Image(new FileInputStream("Images/" + cbDonutType.getValue() + ".png")));
        } catch (Exception e) {
        }
        this.lvDonutFlavor.getSelectionModel().select(0);
        this.update();
    }
}
