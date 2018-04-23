
public class ThreadTest {
	public static void main(String[] args) {
			
		Mythread thread1 = new Mythread();//파생쓰레드
		thread1.start(); //쓰레드가 가지고있는 run()메서드를 실행한다		
		
		
		
		//메인쓰레드
		for (int i = 0; i <100 ; i++) {
		
			System.out.println("메인 : " +i);	
		}
				
		
	}
}
