package btvn3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;
import java.util.Scanner;

public class WorkerThread extends Thread {

	private Socket socket;
	 
    public WorkerThread(Socket socket) {
        this.socket = socket;
    }
 
	public void run() {
        System.out.println("Processing: " + socket);
        try {
        	DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream din = new DataInputStream(socket.getInputStream());
			
			Scanner kb = new Scanner(System.in);
			System.out.println("workerhandler");
			while (true) {
				String st = din.readUTF();
				System.out.println(st);
				System.out.print("Server: ");
				String msg = kb.nextLine();
				dos.writeUTF("Server: "+msg);
				dos.flush();
				kb = kb.reset();
				
			}
        } catch (IOException e) {
            System.err.println("Request Processing Error: " + e);
        }
        System.out.println("Complete processing: " + socket);
    }

}
