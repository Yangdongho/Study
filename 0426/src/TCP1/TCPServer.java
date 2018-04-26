package TCP1;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//연결 요청을 받는곳
public class TCPServer {
	public static void main(String[] args) {
		
		try {
			//요청을 받을 서버의 소켓
			ServerSocket seversocket = new ServerSocket(5000);
			System.out.println("연결대기중....");
			
			Socket socket = seversocket.accept(); //요청 수락 후 연결
			OutputStream os = socket.getOutputStream();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
			writer.write("하이");
			writer.newLine();
			writer.flush();
			
			while(true){
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
