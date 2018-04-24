package StudentManagement;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	public static void main(String[] args) {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		Student[] s = null;
		try {
		
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Student.dat")));
			s = (Student[])in.readObject();
			System.out.println(s);
		
		}catch(FileNotFoundException e) {
			System.out.println("없음");
		}catch(IOException e) {
			
		}catch(ClassNotFoundException e) {
			
		}
		
		StuManage m = new StuManage(s);
		m.Menu();
	/*	Student []tp  = new Student[2];
		tp[0] = new Student("a","a",1,1);1
		tp[1] = new Student("b","b",2,2);*/
				
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Student.dat")));
			out.writeObject(m.stu.getS());
			out.flush();
		}catch(FileNotFoundException e) {
			System.out.println("못찾");
		}catch(IOException e) {
			
		}
		
	}
}
