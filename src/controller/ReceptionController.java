package controller;


import java.util.Observable;
import java.util.Observer;

import application.Reception;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.ApartmentData;
import model.Server;

public class ReceptionController implements Observer {
	
	private Reception main;
	@FXML
	private TextField nameTextField;
	@FXML
	private ChoiceBox<Integer> apartmentChoiceBox;
	@FXML
	private TextArea log;
	
	public void setMain(Reception main) {
		this.main=main;
	}
	
	public void start() {
		nameTextField.setFocusTraversable(false);
		Integer[] opts= {1,2};
		apartmentChoiceBox.getItems().setAll(opts);
		
		Server server= new Server(6002);
		server.addObserver(this);
		Thread t = new Thread(server);
		t.start();		
		
		
	}
	
	public void sendmsg() {
		String msg= "inv;;"+nameTextField.getText() +";; is in the lobby\n";
		if (apartmentChoiceBox.getValue()==1) {
			ApartmentData apData= new ApartmentData(6000,msg);
			Thread t = new Thread(apData);
			t.start();
		}else {
			ApartmentData apData= new ApartmentData(6001,msg);
			Thread t = new Thread(apData);
			t.start();
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {
		log.setText(log.getText()+ "\n"+(String)arg);
		
	}
	
	
	
	
}
