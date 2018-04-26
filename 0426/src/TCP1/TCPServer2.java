package TCP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 implements Runnable {

	public void run() {

		try {
			ServerSocket serversocket = new ServerSocket(5000);
			System.out.println("연결 대기중.....");
			Socket socket = serversocket.accept();//tcp 요청이 있을때까지 blocking된다.
			InputStream in = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
			
			writer.write("연결되었습니다.");
			writer.newLine();
			writer.flush();
			while (true) {
				String msg = br.readLine();
				//serversocket.getInetAddress();
				System.out.println("서버 메세지 " + msg);
				if(msg.equals("quit")) {
					break;
				}
			}
			serversocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
