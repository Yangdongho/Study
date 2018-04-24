import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputEx {
	public static void main(String[] args) {
		FileInputStream f = null;
		int data;
		try {
			f = new FileInputStream("Hi.txt");
			
			while((data= f.read())!=-1) {
				System.out.println((char)data);
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("파일이 없어여");
		}catch(IOException e) {
			
		}
		finally {
			//자원 닫아주기
			try{
				if(f!=null) {
					f.close();
				}
			}catch(IOException e) {
				
			}
		}
	}
}
