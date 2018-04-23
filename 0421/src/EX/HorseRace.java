package EX;

import java.util.Random;

public class HorseRace {
	public static void main(String[] args) {
		Random r = new Random();
		
		int num;
		int sum = 0;
		Runnable race1 = new RaceThread("가");
		Runnable race2 = new RaceThread("나");
		Runnable race3 = new RaceThread("다");
		Runnable race4 = new RaceThread("라");
		
		Thread th1 = new Thread(race1);
		Thread th2 = new Thread(race2);
		Thread th3 = new Thread(race3);
		Thread th4 = new Thread(race4);
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		
		
		
	}
	
}
