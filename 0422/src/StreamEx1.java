import java.io.ByteArrayInputStream;
import java.io.IOException;

public class StreamEx1 {
	public static void main(String[] args) throws IOException{
		
		int read;
		System.out.println("문자를 입력하세요");
		
		while((read = System.in.read())!=-1) {
			
			if(read =='\n' || read == '\r'){
					continue;
			}
			if(read == 'q' || read == 'Q') {
				break;
			}
			
			System.out.println("출력 : "+(char)read);
			
		}
		
	}
}
