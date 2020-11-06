package bai2lop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;



public class ChatServer  {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
			ServerSocket server = new ServerSocket(7000);
			System.out.println("Server is started");
			Socket socket = server.accept();
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream din = new DataInputStream(socket.getInputStream());
			
			Scanner kb = new Scanner(System.in);
			while (true) {
				String st = din.readUTF();
				System.out.println(st);
				System.out.print("Server: ");
				String msg = kb.nextLine();
				dos.writeUTF("Server: "+msg);
				dos.flush();
				kb = kb.reset();
				
			}
		
	}

}
