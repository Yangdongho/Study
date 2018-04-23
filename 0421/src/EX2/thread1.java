package EX2;

public class thread1 extends Thread {
	Thread temp;

	public thread1(Thread thread2) {
		// TODO Auto-generated constructor stub
		this.temp = thread2;
	}

	public void run() {
		

		while (true) {

			Thread.State state = temp.getState();
			System.out.println(state);
			if(state==Thread.State.NEW) {
				
				temp.start();
			}
			else if(state==Thread.State.TERMINATED) {
				break;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
