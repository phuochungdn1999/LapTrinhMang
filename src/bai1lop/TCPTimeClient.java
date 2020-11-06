package bai1lop;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPTimeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("localhost",7788);
			DataInputStream din = new DataInputStream(socket.getInputStream());
			String time = din.readUTF();
			System.out.println(time);
			socket.close();
		}catch(IOException e) {
			return;
		}
		
	}

}
