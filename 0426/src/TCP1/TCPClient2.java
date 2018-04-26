package TCP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class TCPClient2 implements Runnable {

	public void run() {
		
		
		try {
			Scanner sc = new Scanner(System.in);
			Socket socket = new Socket("192.168.0.55", 5000);
			InputStream in = socket.getInputStream();
			java.io.OutputStream out = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
			
			while (true) {
				
				String outMsg = sc.nextLine();
				writer.write(outMsg);
				writer.newLine();
				writer.flush();		
				String msg = br.readLine();
				System.out.println("서버 메세지 " + msg);
			}
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
