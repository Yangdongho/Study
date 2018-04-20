import java.util.Scanner;

public class Multiply2 {

	public static void main(String[] args) {
		int a,b,mul;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("입력 1");
		a = scan.nextInt();
		
		System.out.println("입력 2");
		b = scan.nextInt();
		mul = a * b;
		System.out.println("두 값의 곱은 "+mul);
	} 

}
