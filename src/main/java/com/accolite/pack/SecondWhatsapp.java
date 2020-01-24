package com.accolite.pack;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SecondWhatsapp implements Runnable {
	int port;
	
	Socket socket;
	DataOutputStream dos;
	DataInputStream dis;
	BufferedReader br;
	String user;
	
	SecondWhatsapp() throws IOException
	{
		port = 8998;
		socket = new Socket("127.0.0.1",port);
		dos =new  DataOutputStream (socket.getOutputStream());
		dis = new DataInputStream(socket.getInputStream());
		br = new BufferedReader(new InputStreamReader(System.in));
//		Thread t = new Thread(this);
//		t.start();
//		while(true)
//		{
//			System.out.println(dis.readUTF());
//		}
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				user=br.readLine();
				dos.writeUTF(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		SecondWhatsapp sw = new SecondWhatsapp();
		Thread t = new Thread(sw);
		t.start();
		while(true)
		{
			System.out.println(sw.dis.readUTF());
		}
	}
}
