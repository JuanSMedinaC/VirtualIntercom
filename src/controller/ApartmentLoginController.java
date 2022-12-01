package controller;

import application.Apartment;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class ApartmentLoginController {
	private Apartment main;
	
	@FXML
	ChoiceBox<Integer> numField;
	
	public void setMain(Apartment main) {
		this.main=main;
	}
	
	public void start() {
		Integer[] opts= {1,2};
		numField.getItems().addAll(opts);
		
	}
		
	
	public void login() {
		Apartment.thisNum=numField.getValue();
		main.aptView();
		
	}
	
	
	
}
