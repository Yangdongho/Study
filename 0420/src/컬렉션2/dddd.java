package 컬렉션2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class dddd {

	public static void main(String[] args) {
		
		//Mylist<String> sList = new Mylist<String>();
		//	List<String> slist = new LinkedList<String>();
			
			Map<String,Object> slist = new HashMap<String,Object>();
			//맵에 객체도 넣어보자
			
			
			Student s = new Student("비트",100);
			
			slist.put("학생",s);
			Set<String> a = slist.keySet();
			
			String a1 = (String)a1.toString();
			
		
			
			
			
			/*
			//String a = slist.keySet();
		
			slist.put("1번이다", 1);
			slist.put("2번이다", "ㄴㅇㄹㄴㅇㄹ");
			//rray = (E[])new Object[0];

			Iterator<String> itr = slist.keySet().iterator();
			
			while(itr.hasNext()) {
				String key = itr.next();
				Object temp = slist.get(key);
				System.out.println(key+"  "+temp);
				
			}
			
			List<List<String>> strlist = new ArrayList<List<String>>(); //리스트를 이용한 이차원 배열
			
			List<String> tp = new ArrayList<String>();
			
			tp.add("A");
			tp.add("B");
			tp.add("C");
			tp.add("D");
			tp.add("F");
			strlist.add(tp);
			System.out.println(strlist.get(0).get(4));
		*/
			
	}
}
