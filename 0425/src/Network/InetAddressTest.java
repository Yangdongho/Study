package Network;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress ia = null;
		InetAddress ia1 = null;
		InetAddress[] iarr = InetAddress.getAllByName("www.naver.com");
		//factory method를 사용하여 객체 생성
		try {
			ia = InetAddress.getLocalHost();
			System.out.println(ia.getHostAddress()+ia.getHostName());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ia1= InetAddress.getByName("www.naver.com");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ia1.getHostAddress());
		
		for(InetAddress i : iarr) {
			System.out.println(i.getHostAddress());
		}
	}
}
