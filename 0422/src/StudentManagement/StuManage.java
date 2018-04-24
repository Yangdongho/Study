package StudentManagement;

import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class StuManage {

	final int AllstuNum = 50;
	private int nowStuNum;
	private int type;
	Student[] s = null;
	Student temp = new Student();
	StudentList stu;

	public StuManage(Student[] s) {
		// TODO Auto-generated constructor stub
		stu = new StudentList(s);
		nowStuNum = 0;
		type = 0;
	}

	public void Menu() {

		Scanner sc = new Scanner(System.in);
		while (type != 5) {
			System.out.println("메뉴를 입력하세요. ");
			System.out.println("1.전체 학생 정보보기  2.학생정보추가  3.검색(이름) 4.삭제 5.종료");
			type = sc.nextInt();
			sc.nextLine();
			switch (type) {

			case 1:
				s = stu.getS();
				nowStuNum = stu.getNowStuNum();
				outStu(s, nowStuNum);
				break;

			case 2:
				sc.nextLine();
				Scanner sc1 = new Scanner(System.in);
				System.out.println("학교를 입력하세요.");
				temp.setSchool(sc1.nextLine());
				System.out.println("이름을 입력하세요.");
				temp.setName(sc1.nextLine());
				System.out.println("학년을 입력하세요.");
				temp.setGrade(sc1.nextInt());
				System.out.println("나이를 입력하세요.");
				temp.setAge(sc1.nextInt());
				stu.addStu(temp);

				break;
			case 3:
				find();
				break;
			case 4:
				stu.delete();
				break;

			case 5:
				break;

			default:
				break;

			}

		}
	}

	public void outStu(Student[] s, int nowStuNum) {
		System.out.println("nowStuNum : "+nowStuNum);
		if (nowStuNum == 0) {
			System.out.println("학생 정보가 없습니다.");

		} else {
			for (int i = 0; i < nowStuNum; i++) {
				System.out.println("학교 : " + s[i].getSchool() + "    이름  : " + s[i].getName() + "    학년 : "
						+ s[i].getGrade() + "    나이 : " + s[i].getAge());
			}
		}
		System.out.println();

	}

	public void find() {
		nowStuNum = stu.getNowStuNum();
		s = stu.getS();
		String name;
		Scanner sc = new Scanner(System.in);
		System.out.println("찾을 학생 이름을 입력하세요.");
		name = sc.nextLine();
		System.out.println(name);
		for (int i = 0; i < nowStuNum; i++) {

			if (name.equals(s[i].getName())) {
				System.out.println("학교 : " + s[i].getSchool() + "   이름  : " + s[i].getName() + "   학년 : "
						+ s[i].getName() + "    나이 : " + s[i].getAge());
				System.out.println();
				break;
			}
		}

	}

}
