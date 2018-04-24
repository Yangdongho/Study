package BufferedStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//객체단위로 데이터를 쓸 수 있는 스트림
public class ObjectStreamEx {
	public static void main(String[] args) {
		
		ObjectInputStream in=null;
		ObjectOutputStream out= null;
		Student s = new Student();
		
		s.setName("양동호");
		s.setGrade(6);
		s.setScore(100);

		
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("stu.dat")));
			out.writeObject(s); //직렬화 처리가 필요하다 implements Serializable를 보내고자하는 클래스에 쓰기
			out.flush();
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("stu.dat")));
		s = (Student)in.readObject();
			System.out.println(s);
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			
		}catch(ClassNotFoundException e) {
			
		}
	}
}
