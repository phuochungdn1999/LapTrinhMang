package btvn2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class ServerString {
	public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';
	public String toUpper(String m) {
		String kq = "";
		for (int i = 0; i < m.length(); i++) {
			if(m.charAt(i) >= 'a' && m.charAt(i) <= 'z' ) {
				char x= m.charAt(i);
				x = (char) ((int)m.charAt(i) -32);
				kq += x;
			}
			else {
				kq += m.charAt(i);
			}
		}
    	
    	return kq;
    }
	public String ToLower(String m) {
		String kq = "";
		for (int i = 0; i < m.length(); i++) {
			if(m.charAt(i) >= 'A' && m.charAt(i) <= 'Z' ) {
				char x= m.charAt(i);
				x = (char) ((int)m.charAt(i) + 32);
				kq += x;
			}
			else {
				kq += m.charAt(i);
			}
		}
		return kq;
	}
	public String Togle(String m) {
		String kq = "";
		for (int i = 0; i < m.length(); i++) {
			if(m.charAt(i) >= 'A' && m.charAt(i) <= 'Z' ) {
				char x= m.charAt(i);
				x = (char) ((int)m.charAt(i) + 32);
				kq += x;
			}
			else {
				if(m.charAt(i) >= 'a' && m.charAt(i) <= 'z' ) {
					char x= m.charAt(i);
					x = (char) ((int)m.charAt(i) -32);
					kq += x;
				}
				else {
					kq += m.charAt(i);
				}
			}
		}
		return kq;
	}
	public  int countWords(String input) {
        if (input == null) {
            return -1;
        }
        int count = 0;
        int size = input.length();
        boolean notCounted = true;
        for (int i = 0; i < size; i++) {
            if (input.charAt(i) != SPACE && input.charAt(i) != TAB 
                    && input.charAt(i) != BREAK_LINE) {
                if(notCounted) {
                    count++;
                    notCounted = false;
                }
            } else {
                notCounted = true;
            }
        }
        System.out.print(count);
        return count;
    }
	
	
    public static void main(String[] args) throws Exception {
    	ServerString serverString = new ServerString(); 
    	ServerSocket server = new ServerSocket(9990);
		System.out.println("Server is started");
		Socket socket = server.accept();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		
		Scanner kb = new Scanner(System.in);
		while (true) {
			String st = din.readUTF();
			System.out.println(st);
			String msg = serverString.toUpper(st)+":"+serverString.ToLower(st)+":"+serverString.Togle(st)+":"+serverString.countWords(st);
			dos.writeUTF(msg);
			dos.flush();
			kb = kb.reset();
			
		}
    	
    }
    
    
}
