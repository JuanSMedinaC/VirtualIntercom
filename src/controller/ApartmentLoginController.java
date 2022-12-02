package controller;

import application.Apartment;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class ApartmentLoginController {
	
	// Attributes -----------------------------------------
	private Apartment main;
	
	@FXML
	ChoiceBox<Integer> numField;
	
	// Methods --------------------------------------------
	
	/**
	 * Sets the Main of the class
	 * @param main
	 * @return void
	 */
	public void setMain(Apartment main) {
		this.main = main;
	}
	
	/**
	 * Completes the choiceBox of the interface with the number of the apartments
	 * @return void
	 */
	public void start() {
		Integer[] opts= {1,2};
		numField.getItems().addAll(opts);
		
	}
		
	/**
	 * gets the apartment number the user chooses and takes the user to the resident interface.
	 * @return void
	 */
	public void login() {
		Apartment.thisNum = numField.getValue();
		main.aptView();
		
	}
	
	
	
}
