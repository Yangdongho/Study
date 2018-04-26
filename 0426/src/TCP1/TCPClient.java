package TCP1;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

//연결 요청을 보내는곳
public class TCPClient {
	
	public static void main(String[] args) {
		
		Socket socket = null;
		try {
			
			socket = new Socket("192.168.0.20",5000); //소켓 객체 생성이 연결을 요청하는 행위
			InputStream in = socket.getInputStream(); //요청이 수락되면 소켓을 통해서 데이터를 전송
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String msg = br.readLine();
			System.out.println("서버 메세지"+msg);
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
