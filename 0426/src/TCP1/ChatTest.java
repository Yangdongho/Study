package TCP1;

public class ChatTest {
	public static void main(String[] args) {
		
		Thread client = new Thread(new TCPClient2());
		Thread server = new Thread(new TCPServer2());
		
		client.start();
		server.start();
	}
	
	
	
}
