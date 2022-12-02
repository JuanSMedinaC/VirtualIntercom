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
	private String ip;
	
	public ApartmentData(int port, String msg, String ip) {
		this.port =port;
		this.msg= msg;
		this.ip=ip;
	}
	
	
	@Override
	public void run() {
		
		DataOutputStream out;
		
		
		
		try {
			Socket sc= new Socket(ip,port);
			
			out = new DataOutputStream(sc.getOutputStream());
			
			out.writeUTF(msg);
			
			
			sc.close();
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
