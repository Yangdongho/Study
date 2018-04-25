package RERE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class ChangeEncoding {
	public static void main(String[] args) {
		
		FileInputStream fis= null;
		FileOutputStream fos= null;
		InputStreamReader isr = null;
		
		
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("test.java"),"UTF-8"));
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("testcopy.java"),"MS949"));
			int readChar;
			while((readChar=in.read())!=-1) {
				out.write(readChar);
				out.flush();
			}
			
			
		}catch(FileNotFoundException e) {
			
		}catch(UnsupportedEncodingException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
