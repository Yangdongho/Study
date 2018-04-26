package dd;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Sender implements Runnable {
	private Socket socket;
	String name;
	public Sender(Socket socket,String name) {
		this.socket = socket;
		this.name = name;
	}
	
	public void run() {
		//얘가 할일은 키보드로 부터 입력을 받아서 
		//소켓으로 메시지 전달
		System.out.println(name + "sender");
		Scanner scan = new Scanner(System.in);
		String msg = null;
		BufferedWriter writer = null;
		try {
			//출력하기 위해서 소켓으로 부터 output스트림 얻어오기
			writer = new BufferedWriter(
						new OutputStreamWriter(
							socket.getOutputStream()));
			
			//입력받고 보내기를 계속해서 반복
			while(true) {			
				//키보드에서 입력받기
				msg = scan.nextLine();
				if(msg.equals("quit")) {
					break;
				}
				//입력받은 문자열 writer 스트림으로 내보내기
				writer.write(msg);
				writer.newLine();
				writer.flush();
			}
		}catch(IOException e) {
			System.out.println("상대방이 연결을 종료했습니다.");
		}finally {
			if(writer !=null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
