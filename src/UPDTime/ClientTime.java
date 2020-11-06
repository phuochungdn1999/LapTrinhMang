package UPDTime;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientTime {
	public static void main(String args[])throws Exception{
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		sendData = "getDate".getBytes();
		
		DatagramPacket sendPackage = new DatagramPacket(sendData, sendData.length,IPAddress,9876);
		clientSocket.send(sendPackage);
		DatagramPacket receivePackage = new DatagramPacket(receiveData, receiveData.length);
		
		clientSocket.receive(receivePackage);
		String str = new String(receivePackage.getData());
		System.out.println(str);
		clientSocket.close();
	}
}
