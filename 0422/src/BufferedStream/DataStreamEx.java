package BufferedStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//DataStream - byte단위로 쓰던것을 자바 기초 단위로 데이터를 쓸수 있도록 만들어놓은 스트림

public class DataStreamEx {

	public static void main(String[] args) {
		DataInputStream in;
		DataOutputStream out;
		
		
		try {
			in = new DataInputStream(new BufferedInputStream(new FileInputStream("DADA.txt")));
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("DAD.txt")));
		
		out.writeInt(100);
		out.writeDouble(1.1);;
		out.writeUTF("Hello");
		out.flush(); //버퍼가 꽉차야 내보내기때문에 flush()를 통해 비우도록 함
		
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			
		}
		
		
	}
}
