package BufferedStream;

import java.io.Serializable;

public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4711578010270232403L;
	//클래스의 버전 정보를 확인하는 데이터 객체가 업데이트 되었는지 확인하는 용도
	private String name;
	private int grade;
	private int score;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name,	int grade,int score) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.grade = grade;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", score=" + score + "]";
	}
}
