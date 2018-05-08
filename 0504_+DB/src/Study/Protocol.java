package Study;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Protocol implements Serializable{
	//실제 데이터를 담아서 보낼 클래스
	//실제 데이터 - 다양한 타입이 들어올 수 있음
	//내가 보낼 데이터에 대한 정의
	private Map<String, Object> data;
	
	public Protocol() {
		data = new HashMap<String,Object>();
	}
	
	private int type;
	
	public Map<String, Object> getData() {
		return data;
	}
	
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	
}

