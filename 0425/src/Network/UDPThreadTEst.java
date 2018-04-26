package Network;

public class UDPThreadTEst {
	public static void main(String[] args) {
		
		Thread sender = new Thread(new UDPSenderThread());
		Thread receiver = new Thread(new UDPReceiverThread());
		Thread Server = new Thread(new Server());
		sender.start();
		//receiver.start();
		//Server.start();
		
		
		
	}
}
