
public class ThreadTest1 {
	public static void main(String[] args) {
		
		MyRunnable th = new MyRunnable();
		Thread thread = new Thread(th); 
		thread.start();
		
		
		for (int i = 0; i <100 ; i++) {
			
			System.out.println("메인 : " +i);	
		}
		
		
		
	}
}
