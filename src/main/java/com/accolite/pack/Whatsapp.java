package com.accolite.pack;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Whatsapp implements Runnable{
	int port;
	ServerSocket serverSocket;
	Socket socket;
	DataOutputStream dos;
	DataInputStream dis;
	BufferedReader br;
	String user;
	
	Whatsapp() throws IOException
	{	port = 8998;
		serverSocket = new ServerSocket(port);
		socket = serverSocket.accept();
		dos = new DataOutputStream (socket.getOutputStream());
		dis = new DataInputStream (socket.getInputStream());
		br = new BufferedReader(new InputStreamReader(System.in));
//		Thread t = new Thread(this);
//		t.start();
//		while(true)
//		{
//			System.out.println(dis.readUTF());
//		}
		
	}
	public static void main(String args[]) throws IOException
	{
		Whatsapp w = new Whatsapp();
		Thread t = new Thread(w);
		t.start();
		while(true)
		{
			System.out.println(w.dis.readUTF());
		}
	
	}
	public void run() {
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

}
