package practice;

import java.util.Random;

public class User implements Runnable {
	Bank b;
	String name;

	public User(Bank b,String name) {
		// TODO Auto-generated constructor stub
		this.b = b;
		this.name = name;

	}

	public void run() {
		int value = 10000;
		int num = 0;
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
//			num = r.nextInt(10);
//			if (num % 2 == 0) {
				b.draw(value);
				System.out.println(name+"의 잔액 : "+b.getBalance());
//			} else {
//				b.deposit(value);
//				System.out.println(name+"의 잔액 : "+b.getBalance());
//			}

		}

	}

}
