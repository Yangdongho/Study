package Network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Iterator;


public class Server implements Runnable{

	//private InetAddress[] users = new InetAddress[100];
	HashSet<InetAddress> users = new HashSet<InetAddress>();
	InetAddress temp;
	public void run() {
		
		try {
			DatagramSocket socket = new DatagramSocket(5000);
			DatagramSocket socket2 = new DatagramSocket();

			DatagramPacket packet = null;
			DatagramPacket packet2 = null;
			Iterator<InetAddress> it;
			while(true) {
				System.out.println("수신대기중...");
				byte[] buf = new byte[512];
				packet = new DatagramPacket(buf,buf.length);
				socket.receive(packet);	
				users.add(packet.getAddress());
				it = users.iterator();
				System.out.println();
				while(it.hasNext()) {
					temp = (InetAddress)it.next();//데이터 하나씩 가져오기
					packet2 = new DatagramPacket(buf,buf.length,temp,4000);
					socket2.send(packet2);
					System.out.println("i");
					System.out.println(packet.getAddress()+"  "+new String(buf).trim());
				}
			
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
