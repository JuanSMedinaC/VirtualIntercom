package application;

import controller.ApartmentController;
import controller.ReceptionController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Apartment extends Application{
	public static Stage currentStage=new Stage();
	@Override
	public void start(Stage primaryStage) {
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
			currentStage.show();
			
			
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
