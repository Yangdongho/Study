package StudentManagement;

import java.io.Serializable;

public class Student implements Serializable{

	private String school;
	private String name;
	private int grade;
	private int age;

	// 생성자
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String school, String name, int grade, int age) {
		// TODO Auto-generated constructor stub
		this.school = school;
		this.name = name;
		this.grade = grade;
		this.age = age;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
