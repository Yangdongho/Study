package practice;

public class BankTest {
	public static void main(String[] args) {
		
		Bank b = new Bank();
			
		Runnable u1 = new User(b,"사용자1");
		Runnable u2 = new User(b,"사용자2");
		
		Thread t1 = new Thread(u1);
		Thread t2 = new Thread(u2);
		
		t1.start();
		t2.start();
	}
	
}
