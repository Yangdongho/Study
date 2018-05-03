package Study;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//정보 저장 및 불러오기
public class Server {
	public static void main(String[] args) {
		Socket socket;
		List<Stock> stockList; //Stock객체를 저장하는 리스트 
		//List<Socket> user = new ArrayList<Socket>();
		Thread t;
		HashMap<String,List<Stock>> map = new HashMap<String,List<Stock>>();// 매장이름과 Stock객체리스트로 구성된 맵
		//받아서  DB에 저장하고 보낼때 DB에서 꺼내서 보내주기 유저별 서버 쓰레드가 필요
		/*String productName; //제품 이룸
		int number;// 제품 수량
		int price;*/
		ArrayList<Stock> list = new ArrayList<Stock>();
		list.add(new Stock("신라면",100,500));
		map.put("seoul", list);
		map.put("busan", new ArrayList<Stock>());
		map.put("daejeon", new ArrayList<Stock>());
		
//		map.get("seoul").add(new Stock("신라면",100,500));
		map.get("busan").add(new Stock("과자",190,70000));
		map.get("busan").add(new Stock("커피",110,90000));
		map.get("busan").add(new Stock("물",1200,78800));
		map.get("busan").add(new Stock("컵라면",540,1818));
		map.get("daejeon").add(new Stock("삼양라면",100,1300));
		
		//db추가
		
		try {
			ServerSocket serversocket = new ServerSocket(5000);
			
			while(true) { //유저 접속시 쓰레드 생성 
				socket = serversocket.accept();
				//user.add(socket);
				System.out.println(socket +"연결 성공");
				System.out.println(map.get("seoul"));
				t = new Thread(new Server1(map,socket));
				t.start();
				System.out.println("서버 쓰레드 시작"); 
			}
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
