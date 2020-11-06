package btvn1;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerTime {

	public static void main (String[] args)  {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(9999);
			System.out.println("Server started");
			while(true) {
				Socket socket = server.accept();
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				String time = new Date().toString();
				dos.writeUTF("Server tra lai ngay gio: "+time);
				socket.close();
			}
		}catch(Exception e) {
			return;
		}
		
	}

}
