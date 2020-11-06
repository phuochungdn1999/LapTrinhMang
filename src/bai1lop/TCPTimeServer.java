package bai1lop;

import java.net.*;
import java.util.Date;
import java.io.DataOutputStream;
import java.io.IOException;

public class TCPTimeServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		ServerSocket server = new ServerSocket(7788);
		System.out.println("Server startedd");
		while(true) {
			Socket socket = server.accept();
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String time = new Date().toString();
			dos.writeUTF("Server tra lai ngay gio"+time);
			socket.close();
		}}catch(IOException e) {
			return;
		}
	}

}
