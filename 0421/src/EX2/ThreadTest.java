package EX2;

public class ThreadTest {
	public static void main(String[] args) {
		
		
		/*Runnable r1 = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("익명클래스 ");
				}
			}
		};*/
		
		Runnable r1 = ()-> {
			for (int i = 0; i < 10; i++) {
				System.out.println("익명클래스 ");
			}
		};
		
		Thread t1 = new Thread(r1);
		t1.start();
			for (int i = 0; i < 10; i++) {
				System.out.println("메인클래스 ");
			}
		
		
	}
	
	
	
}
