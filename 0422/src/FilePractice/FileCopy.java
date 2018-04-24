package FilePractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		
		
		byte [] buffer = new byte[512];
		int readlength;
		FileInputStream in;
		FileOutputStream out;
		
		
		try {
			in = new FileInputStream("base.jpg");
			out = new FileOutputStream("copybase.jpg");
			
			while((readlength = in.read(buffer))!=-1) {
				out.write(buffer,0,readlength);
			}
		}catch(FileNotFoundException e) {
			System.out.println("없음");
		}catch(IOException e) {
			
		}
		

		
	}
}
