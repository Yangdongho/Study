import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOuputEx {
	public static void main(String[] args) throws IOException {
		String msg = "File Out";
		
		FileOutputStream f = null;
		
		try {
			f = new FileOutputStream("src/data.txt");
			byte[] bytes = msg.getBytes();
			f.write(bytes);
			
			
		}catch(FileNotFoundException e) {
			
		}finally {
			try {
				if(f !=null) f.close();
			}
			catch(IOException e) {
				
			}
		}
		
	}
}
