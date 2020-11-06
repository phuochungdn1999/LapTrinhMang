package btvn1;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientTime {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket socket = new Socket("localhost",9999);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		String time = din.readUTF();
		System.out.println(time);
		//socket.close();
		
	}

}
