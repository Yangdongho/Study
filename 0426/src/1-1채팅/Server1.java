package dd;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 implements Runnable{
	Socket socket2;
	Socket socket1;
	ServerSocket serversocket = null;
	BufferedReader reader = null;
	BufferedWriter writer = null;
	String msg = null;
	
	public Server1(Socket socket1,Socket socket2) {
		this.socket1=socket1;
		this.socket2=socket2;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		try {
			reader = new BufferedReader(
					 	new InputStreamReader(
					 		socket1.getInputStream()));
			writer = new BufferedWriter(
					new OutputStreamWriter(
						socket2.getOutputStream()));	
			while(true) {				
				msg = reader.readLine();
				System.out.println("상대방 : " + msg);
				writer.write(msg);
				writer.newLine();
				writer.flush();
			}
		} catch (IOException e) {
			System.out.println("서버 연결 종료");
		}
	}
	public Socket getSocket2() {
		return socket2;
	}
	public void setSocket2(Socket socket2) {
		this.socket2 = socket2;
	}
	public void setSocket1(Socket socket1) {
		this.socket1 = socket1;
	}
	public Socket getSocket1() {
		return socket1;
	}
	
	
	
	
}
