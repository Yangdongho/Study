package RERE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamReader {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		InputStreamReader isr =null;
		OutputStreamWriter osw = null;
		
		isr = new InputStreamReader(System.in);
		osw = new OutputStreamWriter(System.out);
		
		br = new BufferedReader(isr);
		bw = new BufferedWriter(osw);
		
		try {
			String id = br.readLine();
			bw.write("id : "+id+"\n");
			bw.flush();
			String pass = br.readLine();
			bw.write("pass : "+pass+"\n");
			bw.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}

//InputStreamReader OutputStreamWriter
//바이트 스트림과 문자스트림의 중간다리역할
