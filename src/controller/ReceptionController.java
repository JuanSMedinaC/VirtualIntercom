package controller;


import application.Reception;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ReceptionController {
	
	private Reception main;
	@FXML
	private TextField nameTextField;
	@FXML
	private ComboBox<String> apartmentComboBox;
	
	public void setMain(Reception main) {
		this.main=main;
	}
	
	public void start() {
		nameTextField.setFocusTraversable(false);
	}
}
