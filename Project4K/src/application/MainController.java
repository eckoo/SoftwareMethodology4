package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class is the controller for the Main Menu and allows for data to be
 * manipulated based on the user's actions
 *
 * @author Kiernan King and Ahmed Alghazwi
 */
public class MainController {

	/**
	 * Creates imgVDonut FXML Object of type ImageView.
	 */
    @FXML
    private ImageView imgVDonut;
    
    /**
     * Creates imgVCofee FXML Object of type ImageView.
     */
    @FXML
    private ImageView imgVCofee;
    
    /**
     * Creates imgStoreOrder FXML Object of type ImageView.
     */
    @FXML
    private ImageView imgStoreOrder;
    
    /**
     * Creates imgYourOrder FXML Object of type ImageView.
     */
    @FXML
    private ImageView imgYourOrder;

    /**
     * This method initializes the main menu scene.
     */
    public void initialize() {

        try {
            imgVDonut.setImage(new Image(new FileInputStream("Images/donuts.png")));
            imgVCofee.setImage(new Image(new FileInputStream("Images/coffee.png")));
            imgStoreOrder.setImage(new Image(new FileInputStream("Images/clipboard.png")));
            imgYourOrder.setImage(new Image(new FileInputStream("Images/shopping-bag.png")));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    /**
     * This method opens the Donut menu.
     *
     * @param event Object of type MouseEvent.
     */
    @FXML
    public void orderDonut(MouseEvent event) {
        openView("OrderingDonutsView.fxml", "Donut Menu");
    }

    /**
     * This method opens the Coffee menu.
     *
     * @param event Object of type MouseEvent.
     */
    @FXML
    public void orderCoffee(MouseEvent event) {
        openView("OrderingCoffeeView.fxml", "Coffee Menu");
    }

    /**
     * This method opens the Order page.
     *
     * @param event Object of type MouseEvent.
     */
    @FXML
    public void yourOrder(MouseEvent event) {
        openView("YourOrderView.fxml", "Your Order");
    }

    /**
     * This method opens the Store Orders page.
     *
     * @param event Object of type MouseEvent.
     */
    @FXML
    public void storeOrder(MouseEvent event) {
        openView("StoreOrdersView.fxml", "Store Orders");
    }

    /**
     * openView method.
     * @param path Object of type String.
     * @param title Object of type String.
     */
    private void openView(String path, String title) {
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
