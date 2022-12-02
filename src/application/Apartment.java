package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import controller.ApartmentController;
import controller.ApartmentLoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.ApartmentData;

public class Apartment extends Application{
	public static Stage currentStage=new Stage();
	public static int thisPort=0;
	public static int thisNum=0;
	
	/**
	 * Loads the screen to choose the desired apartment number.
	 * @param primaryStage
	 * @return void
	 */
	@Override
	public void start(Stage primaryStage) {
		BorderPane root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/ApartmentLogin.fxml"));
			root = (BorderPane)loader.load();
			ApartmentLoginController apController= loader.getController();
			apController.setMain(this);

			Scene scene = new Scene(root);
			currentStage.setScene(scene);
			currentStage.setWidth(800);
			currentStage.setHeight(600);
			currentStage.setResizable(false);
			currentStage.show();
			
			apController.start();
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Loads the resident interface 
	 * @return void
	 */
	public void aptView() {
		BorderPane root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Apartment.fxml"));
			root = (BorderPane)loader.load();
			ApartmentController apController= loader.getController();
			apController.setMain(this);

			Scene scene = new Scene(root);
			currentStage.setScene(scene);
			currentStage.setHeight(600);
			currentStage.setWidth(800);
			currentStage.setResizable(false);
			currentStage.show();
			
			apController.start();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
		
		
	}

}
