package Study;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Server1 implements Runnable{
	Socket temp;
	Socket socket;
	ServerSocket serversocket = null;
	ObjectInputStream reader = null;
	ObjectOutputStream writer= null;
	//BufferedWriter writer = null;
	
	//List<Socket> user = new ArrayList<Socket>();
	HashMap<String,List<Stock>> map;
	
	public Server1(HashMap<String,List<Stock>> map,Socket socket) {
		this.map = map;
		this.socket = socket;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	
	public void run() {
		
		try {	
			reader = new ObjectInputStream(socket.getInputStream());	
			writer = new ObjectOutputStream(socket.getOutputStream());
			while(true) {				
				Protocol outp;
				Protocol p;
				
				p = (Protocol) reader.readObject();			
				
				
				if(p.getType()==100) {
					outp= new Protocol();
					Map<String, Object> data = new HashMap<String, Object>();
					data.put("init",map);
					outp.setData(data);
					outp.setType(100);
					writer.writeObject(outp);
					writer.flush();
					
				}else if(p.getType()==200) {
				
					System.out.println("delete 받음");
					String temp = (String) p.getData().get("delete");
					System.out.println("서버가 받은 : "+temp);
					String[] data = temp.split(" ");
					String k = data[0];
					int n = Integer.parseInt(data[1]);
					map.get(k).remove(n);
					
					for(int i = 0; i < map.get("busan").size(); i++) {
			            System.out.println(map.get("busan").get(i));
					}
					
					
					outp= new Protocol();
					Map<String, Object> data1 = new HashMap<String, Object>();
					data1.put("delete",map);
					outp.setData(data1);
					outp.setType(200);
					System.out.println("서버가 보낸 타입  "+outp.getType());
					writer.writeObject(outp);
					writer.flush();
				}else if(p.getType()==300) {
					String temp = (String) p.getData().get("add");
					String[] data = temp.split(" ");
					String k = data[0];			
					map.get(k).add(new Stock(data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3])));
					
					for(int i = 0; i < map.get("daejeon").size(); i++) {
			            System.out.println(map.get("daejeon").get(i));
					}
					outp= new Protocol();
					Map<String, Object> data1 = new HashMap<String, Object>();
					data1.put("add",map);
					outp.setData(data1);
					outp.setType(300);
					System.out.println("서버가 보낸 타입  "+outp.getType());
					writer.writeObject(outp);
					writer.flush();
					
				
				}else if(p.getType()==400) {
					
					String temp = (String) p.getData().get("update");
					String[] data = temp.split(" ");
					String k = data[0];
					int num = Integer.parseInt(data[1]);
					
					map.get(k).set(num, new Stock(data[2],Integer.parseInt(data[3]),Integer.parseInt(data[4])));
					
					for(int i = 0; i < map.get("busan").size(); i++) {
			            System.out.println(map.get("busan").get(i));
					}
					
					outp= new Protocol();
					Map<String, Object> data1 = new HashMap<String, Object>();
					data1.put("update",map);
					outp.setData(data1);
					outp.setType(400);
					System.out.println("서버가 보낸 타입  "+outp.getType());
					writer.writeObject(outp);
					writer.flush();
				}
				
				
				
				writer.reset();
			}
		} catch (IOException e) {
			System.out.println("서버 연결 종료");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
