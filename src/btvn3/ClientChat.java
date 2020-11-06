package btvn3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {

	public final static String SERVER_IP = "127.0.0.1";
    public final static int SERVER_PORT = 7;
 
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
            System.out.println("Connected: " + socket);
 
            DataInputStream din = new DataInputStream(socket.getInputStream());
    		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
    		
    		Scanner kb = new Scanner(System.in);
    		while(true) {
    			System.out.print("Client: ");
    			String msg = kb.nextLine();
    			dos.writeUTF("Client: "+msg);
    			dos.flush();
    			
    			String st = din.readUTF();
    			System.out.println(st);
    			kb = kb.reset();
    		}
        } catch (IOException ie) {
            System.out.println("Can't connect to server");
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

}
