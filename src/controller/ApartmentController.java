package controller;

import java.util.Observable;
import java.util.Observer;

import application.Apartment;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.ApartmentData;
import model.Server;

public class ApartmentController implements Observer{
	private Apartment main;
	
	private String lastName;
	
	@FXML
	TextArea textSpace, chatSpace, recSpace;

	public void setMain(Apartment apartment) {
		this.main=main;		
	}
	
	public void start() {
		if (main.thisNum==1) {
			Server server= new Server(6000);
			server.addObserver(this);
			Thread t = new Thread(server);
			t.start();
		}else {
			Server server= new Server(6001);
			server.addObserver(this);
			Thread t = new Thread(server);
			t.start();
		}
		
	}
	
	/**
	 * will send a message to the other appertment
	 * @param event ENTER key
	 */
	public void sendmsg(KeyEvent event) {
		if(event.getCode() == KeyCode.ENTER)
		{
			String msg= "msg;; "+Apartment.thisNum + ":" + textSpace.getText() + "\n";
			String[] msgSpaced= msg.split(";;");
			chatSpace.setText(chatSpace.getText()+ msgSpaced[1]);
			textSpace.clear();
			if (main.thisNum==1) {
				ApartmentData apData= new ApartmentData(6001,msg, "127.0.0.1"); //ip del apto 2
				Thread t = new Thread(apData);
				t.start();
			}else {
				ApartmentData apData= new ApartmentData(6000,msg, "127.0.0.1"); //ip del apto 1
				Thread t = new Thread(apData);
				t.start();
			}
		}
		
	}
	
	
	public void sendmsgByButton() {
		String msg= "msg;; "+Apartment.thisNum + ":" + textSpace.getText() +"\n";
		String[] msgSpaced= msg.split(";;");
		chatSpace.setText(chatSpace.getText()+ msgSpaced[1]);
		textSpace.clear();
		if (main.thisNum==1) {
			ApartmentData apData= new ApartmentData(6001,msg, "127.0.0.1"); //ip apto 2
			Thread t = new Thread(apData);
			t.start();
		}else {
			ApartmentData apData= new ApartmentData(6000,msg, "127.0.0.1"); //ip apto 1
			Thread t = new Thread(apData);
			t.start();
		}
	}
	
	public void sos() {
		String msg="The apartment #"+ Apartment.thisNum+ " has pressed the panic button, needs help!";
		ApartmentData apData = new ApartmentData(6002,msg, "127.0.0.1"); //ip de la recepción 
		Thread t = new Thread(apData);
		t.start();
	}
	
	public void admit() {
		if (lastName!=null) {
			String msg="The apartment #"+ Apartment.thisNum+ " has admited the entrance of " + lastName;
			ApartmentData apData= new ApartmentData(6002,msg, "127.0.0.1");
			Thread t = new Thread(apData);
			t.start();
		}
		lastName=null;
	}
	
	public void deny() {
		if (lastName!=null) {
			String msg="The apartment #"+ Apartment.thisNum+ " has denied the entrance of " + lastName;
			ApartmentData apData= new ApartmentData(6002,msg, "127.0.0.1"); //ip de la recepción 
			Thread t = new Thread(apData);
			t.start();
		}
		lastName=null;
	}

	

	@Override
	public void update(Observable o, Object arg) {
		String msg= (String) arg;
		String[] msgSpaced= msg.split(";;");
		
		if (msgSpaced[0].equalsIgnoreCase("msg")) {
			chatSpace.setText(chatSpace.getText()+ msgSpaced[1]);
		}else if(msgSpaced[0].equalsIgnoreCase("inv")) {
			recSpace.setText( msgSpaced[1]+ msgSpaced[2]);
			lastName=msgSpaced[1];
		}
		
		
	}
	
	
	
}
