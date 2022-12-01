package application;
	
import java.net.*;
import java.util.ArrayList;
import java.io.*;

import controller.*;
import javafx.application.Application;
import javafx.stage.Stage;
import model.ApartmentData;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Reception extends Application {
	public static Stage currentStage=new Stage();
	public static ApartmentData apt1=null;
	public static ApartmentData apt2=null;
	@Override
	public void start(Stage primaryStage) {
		BorderPane root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Reception.fxml"));
			root = (BorderPane)loader.load();
			ReceptionController recController= loader.getController();
			recController.setMain(this);

			Scene scene = new Scene(root);
			currentStage.setScene(scene);
			currentStage.setHeight(600);
			currentStage.setWidth(800);
			currentStage.show();
			
			recController.start();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
