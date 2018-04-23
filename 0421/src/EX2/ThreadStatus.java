package EX2;

public class ThreadStatus {
	 public static void main(String[] args) {
		Thread Thread2 = new thread2();
		Thread Thread1 = new thread1(Thread2);
		
		Thread1.start();
		 
	}
}
