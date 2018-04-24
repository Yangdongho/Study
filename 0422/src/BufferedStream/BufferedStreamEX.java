package BufferedStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//데이터 처리 스트림인 BufferedStream으로 부터 데이터를 받아서 사용
//4069byte
public class BufferedStreamEX {
	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		BufferedInputStream bin;
		BufferedOutputStream bout;
		
		try {
		out = new FileOutputStream("number.txt");
		//버퍼 스트림을 통해서 효율적으로 사용하기 위함
		bout = new BufferedOutputStream(out);
		for (int i = 0; i < 300; i++) {
			bout.write(i);
			//버퍼에 담아두가가 가득차면 스트림으로 데이터를 내보낸다
			
		}
		bout.flush();
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			
		}finally {
			try {
				if(out !=null) out.close();
			}
			catch(IOException e) {
				
			}
		}
				
		try {
			
			in = new FileInputStream("number.txt");
			bin = new BufferedInputStream(in);
			int data;
			System.out.println("sdsdf");
			
			while( (data=bin.read() )!=-1) {
				System.out.println(data);
			}
			
			
		}catch(FileNotFoundException e) {
			System.out.println("못찾");
		}catch(IOException e) {
			
		}
		
		
		
		
		
		
	}
	
}
