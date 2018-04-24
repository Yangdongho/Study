package FilePractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStu {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		FileInputStream fr = null;
		FileOutputStream fo = null;
		Student stu = null;
		String []temp;
		String msg = null;
		int data; //read가 int형으로 반환하기 때문에
		try {
			fr = new FileInputStream("Stu.txt");
			while((data = fr.read())!=-1) {
				sb.append((char)data);
				System.out.print((char)data);
			}
			System.out.println();
			temp = sb.toString().split(" ");
			stu = new Student(temp[0], Integer.valueOf(temp[1]),Integer.valueOf(temp[2]));
			
		}catch(FileNotFoundException e){
			System.out.println("파일 없어");
		}catch(IOException e){
			
		}finally{
			try {
				if(fr!=null) fr.close();
			}
			catch(IOException e) {
				
			}
		}
		sb.setLength(0);
		System.out.println(stu);
		stu.setName("FileStream");
		stu.setGrade(6);
		stu.setScore(0);
		sb.append(stu.getName()+" ");
		sb.append(stu.getGrade()+" ");
		sb.append(stu.getScore()+" ");
		msg = sb.toString();
		System.out.println(msg);
		try {
			fo = new FileOutputStream("StreamStu.txt");
			byte[] bytes = msg.getBytes();
			fo.write(bytes);
			
			
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			
		}
		finally {
			try {
				if(fo !=null) fo.close();
			}
			catch(IOException e) {
				
			}
		}
		
	}
}
