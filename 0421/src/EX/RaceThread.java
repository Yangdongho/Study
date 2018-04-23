package EX;

import java.util.Random;

public class RaceThread implements Runnable {
	String name;
	public RaceThread(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public void run() {
		Random r = new Random();
		int num;
		int sum = 0;

		while (sum < 50) {
			num = r.nextInt(5) + 1;
			sum = sum + num;
			
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				
			
			}
			System.out.println(name+" 달린 거리 : " + sum);
			
		}
		System.out.println(name+" 종료");
	}
}
