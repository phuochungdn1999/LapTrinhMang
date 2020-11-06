package btvn2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket socket = new Socket("localhost",9990);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());

		Scanner kb = new Scanner(System.in);
		while(true) {
			String msg = kb.nextLine();
			dos.writeUTF(msg);
			dos.flush();
			
			String st = din.readUTF();
			String[] newSt = st.split(":");
			System.out.println("Chu hoa: "+ newSt[0]);
			System.out.println("Chu thuong: "+newSt[1]);
			System.out.println("Vua hoa vua thuong: "+newSt[2]);
			System.out.println("Dem so ki tu: "+newSt[3]);
			kb = kb.reset();
		}
		
	}
}
