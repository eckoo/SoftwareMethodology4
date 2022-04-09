package application;

import java.io.IOException;

import DonutsAndCoffee.Order;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * This is the Main class.
 *
 * @author Kiernan King and Ahmed Alghazwi
 *
 */
public class Main extends Application {

	/**
	 * Creates myOrder Object of type Order.
	 */
    public static Order myOrder = new Order();
    
    /**
     * Creates myStore Object of type StoreOrders.
     */
    public static StoreOrders myStore = new StoreOrders();

    /**
     * This method starts the GUI.
     *
     * @param primaryStage the main menu stage.
     * @throws IOException exception
     */
    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * Launches the GUI.
     *
     * @param args the stage
     */
    public static void main(String[] args) {
        launch(args);
    }
}
