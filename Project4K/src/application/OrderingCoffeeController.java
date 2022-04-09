package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import DonutsAndCoffee.Coffee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.control.TextField;

import javafx.scene.control.ComboBox;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * This class is a Controller for the Coffee menu.
 * It allows users to add Coffee to their order.
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class OrderingCoffeeController implements Initializable {

	/**
	 * Creates coffee Object of type Coffee.
	 */
    private Coffee coffee;

    /**
     * Creates imageCoffe FXML Object of type ImageView.
     */
    @FXML
    private ImageView imageCoffe;
    
    /**
     * Creates chkbCream FXML Object of type CheckBox.
     */
    @FXML
    private CheckBox chkbCream;
    
    /**
     * Creates chkbSyrup FXML Object of type CheckBox.
     */
    @FXML
    private CheckBox chkbSyrup;
    
    /**
     * Creates chkbMilk FXML Object of type CheckBox.
     */
    @FXML
    private CheckBox chkbMilk;
    
    /**
     * Creates chkbCaramel FXML Object of type CheckBox.
     */
    @FXML
    private CheckBox chkbCaramel;
    
    /**
     * Creates chkbWhippedCream FXML Object of type CheckBox.
     */
    @FXML
    private CheckBox chkbWhippedCream;
    
    /**
     * Creates txtTotal FXML Object of type TextField.
     */
    @FXML
    private TextField txtTotal;
    
    /**
     * Creates cbCoffeeSize FXML Object of type ComboBox String.
     */
    @FXML
    private ComboBox<String> cbCoffeeSize;
    
    /**
     * Creates cbQuantity FXML Object of type ComboBox Integer.
     */
    @FXML
    private ComboBox<Integer> cbQuantity;

    /**
     * This method initializes the scene as well as some default options for the user.
     * @param location Object of type URL.
     * @param resources Object of type ResourceBundle.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            imageCoffe.setImage(new Image(new FileInputStream("Images/coffee.png")));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        cbCoffeeSize.getItems().addAll(Coffee.SIZE);
        cbQuantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        coffee = new Coffee("Short", 1);

        update();
    }

    /**
     * This helper method updates the current page to match any changes made by the user.
     */
    private void update() {
        double total = coffee.itemPrice();
        txtTotal.setText(coffee.formatPrice(total));
    }

    /**
     * This function is called when user clicks Add to Order, it adds a Coffee
     * Object to the current Order.
     *
     * @param e Object of type ActionEvent.
     */
    @FXML
    private void addToOrder(ActionEvent e) {

        Alert confirmation = new Alert(AlertType.INFORMATION);
        confirmation.setTitle("Confirmation");
        confirmation.setHeaderText("Confirmation");
        confirmation.setContentText("Coffee has been added to Order");
        confirmation.show();

        //RunningTotal.setText("gent1");
        Main.myOrder.add(coffee);

        ((Stage) ((Node) e.getSource()).getScene().getWindow()).close();

    }

    /**
     * This function is called when the Add-In is selected.
     *
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void addInChanged(ActionEvent event) {
        CheckBox chkBox = (CheckBox) event.getSource();
        if (chkBox.isSelected()) {
            coffee.add(chkBox.getText());
        } else {
            coffee.remove(chkBox.getText());
        }
        update();
    }

    /**
     * This function is called when the Coffee size is selected.
     *
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void sizeChanged(ActionEvent event) {
        coffee.setSize(cbCoffeeSize.getValue());
        update();
    }

    /**
     * This function is called when the quantity of Coffee.
     *
     * @param event Object of type ActionEvent.
     */
    @FXML
    private void quantityChanged(ActionEvent event) {
        coffee.setQuantity(cbQuantity.getValue());
        update();
    }

}
