import java.util.Scanner;

public class Salary {
	public static void main(String[] args) {
		
		int sum;
		int account;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("월 저축액을 입력하세요");
		
		account = scan.nextInt();
		sum= account*12*10;
		
		System.out.println("10년 동안의 저축액 : "+sum);
		

	}
	
}
