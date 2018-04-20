import java.util.Scanner;

public class CircleArea {
	public static void main(String[] args) {
		
		double p = 3.14;
		int radius;
		double circleArea;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("반지름을 입력하세요");
		radius = sc.nextInt();
		circleArea = p*radius*radius;
		
		System.out.println("반지름이 "+radius+"인 원의 넓이는 "+circleArea+"입니다");
		System.out.printf(" 반지름 %d",radius);
		System.out.printf(" 넓이 %.2f",circleArea);
	}
}