package EX2;

public class thread2 extends Thread{
	public void run() {
		for (int i = 0; ; i++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
