package Network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiverThread implements Runnable{
	
		
		//localhost 127.0.0.1
		//패킷을 받기전에 미리 포트를 점유하고 있어야 하기 때문에 소켓을 만들때 포트번호 지정
		public void run() {
			try {
			DatagramSocket socket = new DatagramSocket(4000);
			byte[] buf = null;
			DatagramPacket packet = null;
			
			while(true) {
				System.out.println("수신대기중...");
				buf = new byte[512];
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				System.out.println(packet.getAddress()+new String(buf).trim()); //buf를 스트링으로 만들고 null값지워줌
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
