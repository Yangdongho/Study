package RERE;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriter {
	public static void main(String[] args) {
		
		FileReader reader = null;
		FileWriter writer = null;
		int readChar;
		StringBuffer sf = new StringBuffer();
		try {
			reader = new FileReader("test.txt");
			writer = new FileWriter("testcopy.txt");
			
			while( (readChar=reader.read())!=-1) {
				writer.write(readChar);
				writer.flush();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(writer!=null) writer.close();
					if(reader!=null) reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
	}
}
