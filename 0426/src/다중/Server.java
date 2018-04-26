package 다중;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server{
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Socket socket;
		List<Socket> user = new ArrayList<Socket>();
		Thread t;
		//데이터를 소켓으로부터 읽어오기 위해서 스트림을 얻어옴
		try {
			ServerSocket serversocket = new ServerSocket(5000); //5000번 포트를 열어둔다.
			while(true) {
				socket = serversocket.accept();
				user.add(socket);
				System.out.println(socket);
				t = new Thread(new Server1(user,socket));
				t.start();
			}
			
			
		
			
		} catch (IOException e) {
			System.out.println("상대방이 연결을 종료했습니다.");
		}finally {
			
		}
	
	}
	
}
