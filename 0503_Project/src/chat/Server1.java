package chat;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server1 implements Runnable{
	Socket temp;
	Socket socket;
	ServerSocket serversocket = null;
	BufferedReader reader = null;
	BufferedWriter writer = null;
	String msg = null;
	List<Socket> user = new ArrayList<Socket>();
	
	public Server1(List<Socket> user,Socket socket) {
		this.user = user;
		this.socket = socket;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		try {	
			reader = new BufferedReader(
					 	new InputStreamReader(
					 		socket.getInputStream()));
			
			while(true) {				
				msg = reader.readLine();
				System.out.println(socket+" - " + msg);
				
				for (int i = 0; i < user.size(); i++) {
					temp = user.get(i);
					if(temp==socket) continue;
					
					writer = new BufferedWriter(
							new OutputStreamWriter(
								temp.getOutputStream()));
					writer.write(msg);
					writer.newLine();
					writer.flush();
				}
			}
		} catch (IOException e) {
			System.out.println("서버 연결 종료");
		}
	}
	
	
	
	
	
}
