package Network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPSenderThread implements Runnable{

	public void run() {
	try {
		DatagramSocket socket = new DatagramSocket(); //데이터가 나갈 통로
		InetAddress ia = InetAddress.getByName("192.168.0.55");
		String msg;
		DatagramPacket packet = null;
		byte[] buf;
		Scanner sc = new Scanner(System.in);
		
		while(true){
			msg = sc.nextLine();
			if(msg.equals("quit")) break;
			else {
				buf=msg.getBytes();
				packet = new DatagramPacket(buf, buf.length,ia,5000); //패킷에 정보,정보길이,아이피,포트를 추가하여 만듬
				socket.send(packet);
			}
		}
		
		
		
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SocketException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
