package model;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ApartmentData implements Runnable{
	
	private int port;
	private String msg;
	private int aptNum;
	private DataInputStream in;
	private DataOutputStream out;
	
	public ApartmentData(int port, String msg) {
		this.port =port;
		this.msg= msg;		
	}
	
	
	@Override
	public void run() {
		String observerIp="127.0.0.1";
		
		DataOutputStream out;
		
		
		
		try {
			Socket sc= new Socket(observerIp,port);
			
			out = new DataOutputStream(sc.getOutputStream());
			
			out.writeUTF(msg);
			
			
			sc.close();
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
