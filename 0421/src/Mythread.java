
public class Mythread extends Thread{
	public void	 run() {
		System.out.println();
		
		for (int i = 0; i <100 ; i++) {
			System.out.println("MY : " +i);		
		}
	}
}
