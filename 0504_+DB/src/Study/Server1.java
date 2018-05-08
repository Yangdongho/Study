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

public class Server1 implements Runnable {
	Socket temp;
	Socket socket;
	ServerSocket serversocket = null;
	ObjectInputStream reader = null;
	ObjectOutputStream writer = null;
	HashMap<String, List<Stock>> map;
	stockDao dao = new stockDao();
	// 둘다 상관 없음

	public Server1(Socket socket) {
		this.socket = socket;

		// TODO Auto-generated constructor stub
	}

	@Override

	public void run() {

		try {
			reader = new ObjectInputStream(socket.getInputStream());
			writer = new ObjectOutputStream(socket.getOutputStream());
			while (true) {
				Protocol outp;
				Protocol p;
				int dbIndex = 0;
				p = (Protocol) reader.readObject();

				if (map != null) {
					Iterator<String> itr = map.keySet().iterator();
					while (itr.hasNext()) {
						String key = itr.next();
						dbIndex = dbIndex + map.get(key).size();
						System.out.println("서버 쓰레드 인덱스 : " + dbIndex);
					}
				}

				if (p.getType() == 100) {
					map = dao.select();
					outp = new Protocol();
					Map<String, Object> data = new HashMap<String, Object>();
					data.put("init", map);
					outp.setData(data);
					outp.setType(100);
					writer.writeObject(outp);
					writer.flush();

				} else if (p.getType() == 200) {

					System.out.println("delete 받음");
					String temp = (String) p.getData().get("delete");
					System.out.println("서버가 받은 : " + temp);
					String[] data = temp.split(" ");
					String k = data[0];
					int n = Integer.parseInt(data[1]);
					
					dao.delete(map.get(k).get(n).getIndex());
					map.get(k).remove(n);
					/*System.out.println(k+" @@@@ "+n);
					
					System.out.println("삭제할 키의 리스트 사이즈 : "+map.get(k).size());
					
					System.out.println("삭제할 놈 디비 인덱스 ---->"+map.get(k).get(n).getIndex());
					*/
					

					outp = new Protocol();
					Map<String, Object> data1 = new HashMap<String, Object>();
					data1.put("delete", map);
					outp.setData(data1);
					outp.setType(200);
					System.out.println("서버가 보낸 타입  " + outp.getType());
					writer.writeObject(outp);
					writer.flush();

				} else if (p.getType() == 300) {
					String temp = (String) p.getData().get("add");
					String[] data = temp.split(" ");
					String k = data[0];
					System.out.println(data.toString());

					map.get(k).add(
							new Stock(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), (dbIndex + 1)));
					dao.insert(k, new Stock(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), dbIndex));

					outp = new Protocol();
					Map<String, Object> data1 = new HashMap<String, Object>();
					data1.put("add", map);
					outp.setData(data1);
					outp.setType(300);
					System.out.println("서버가 보낸 타입  " + outp.getType());
					writer.writeObject(outp);
					writer.flush();

				} else if (p.getType() == 400) {

					String temp = (String) p.getData().get("update");
					String[] data = temp.split(" ");
					String k = data[0];
					int num = Integer.parseInt(data[1]);
					
					
					//map.get(k).set(num, new Stock(data[2],Integer.parseInt(data[3]),Integer.parseInt(data[4])));
					map.get(k).get(num).setProductName(data[2]);
					map.get(k).get(num).setNumber(Integer.parseInt(data[3]));
					map.get(k).get(num).setPrice(Integer.parseInt(data[4]));
					dao.update(map.get(k).get(num));
					
	
					outp = new Protocol();
					Map<String, Object> data1 = new HashMap<String, Object>();
					data1.put("update", map);
					outp.setData(data1);
					outp.setType(400);
					System.out.println("서버가 보낸 타입  " + outp.getType());
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
