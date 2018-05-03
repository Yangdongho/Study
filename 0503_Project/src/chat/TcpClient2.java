package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient2 {
	public static void main(String[] args) {
		//소켓부터 만들어 내야 한다 : 요청을 받고 수락해서  
		//sender, recevier 하나씩 실행
		try {
			Socket socket =   new Socket("192.168.0.20", 5000);
			
			Thread sender = new Thread(new Sender(socket,"2번 사용자"));
			Thread receiver = new Thread(new Receiver(socket,"2"));
			sender.start();
			receiver.start();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}