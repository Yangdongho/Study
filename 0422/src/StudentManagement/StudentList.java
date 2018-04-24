package StudentManagement;

import java.util.Scanner;

public class StudentList {

	private Student[] s = null;
	private int nowStuNum;
	public StudentList(Student []s) {
		this.s = s;
		
		if(s!=null) nowStuNum = s.length;
		else nowStuNum=0;
	}

	public void addStu(Student temp) {
		Student[] Stu = new Student[nowStuNum + 1];
		
		for (int i = 0; i < nowStuNum; i++) {
			Stu[i] = s[i];
			System.out.println(i+"번 배열 복사  "+s[i].getName()+"  "+Stu[i].getName());
		}
		Stu[nowStuNum] = temp;
		s = Stu;
	//	System.out.println(nowStuNum);
		nowStuNum++;
		//System.out.println(s[0].getName());
	
		System.out.println("학생 정보가 추가 되었습니다.");
		System.out.println();

	}

	public void delete() {
		String name;
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제 할 학생 이름을 입력하세요.");
		name = sc.nextLine();

		for (int i = 0; i < nowStuNum; i++) {

			if (name.equals(s[i].getName())) {
				for (int j = i; j < nowStuNum - 1; j++) {
					s[i] = s[j + 1];
				}
				nowStuNum--;

				System.out.println("학생 정보가 삭제 되었습니다.");
				System.out.println();
				break;
			}
		}

	}

	public int size() {
		return nowStuNum;
	}

	public Student[] getS() {
		return s;
	}

	public void setS(Student[] s) {
		this.s = s;
	}

	public int getNowStuNum() {
		return nowStuNum;
	}

	public void setNowStuNum(int nowStuNum) {
		this.nowStuNum = nowStuNum;
	}

}
