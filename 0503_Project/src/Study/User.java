package Study;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;

//매장별 제품 추가 ,수정
public class User extends JFrame {

	Socket socket;
	ObjectOutputStream writer = null;
	Thread receiver = null;
	JList list;
	JList list_1;
	JTable table;
	JScrollPane scroll;
	HashMap<String, List<Stock>> map = null;
	Protocol p;
	static final String header[] = { "품명", "수량", "단가" };
	private boolean isIn = true;
	private DefaultTableModel model = null;
	ObjectInputStream reader = null;
	String deleteKey;
	String addKey;
	String updateKey;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	// 메뉴, 각버튼 기능,TCP관련으로 나누기

	public User() {
		getContentPane().setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));

		try {
			socket = new Socket("192.168.0.20", 5000);
			// writer = new BufferedWriter(new
			// OutputStreamWriter(socket.getOutputStream()));
			writer = new ObjectOutputStream(socket.getOutputStream());
			receiver = new Thread(new Receiver(socket));
			receiver.start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.setSize(727, 494);
		getContentPane().setLayout(null);

		JButton buttonAdd = new JButton("품목 추가");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("추가 버튼 활성화");
				p = new Protocol();
				String key = list.getSelectedValue().toString();
				addKey = key;
				key= key+" "+textField.getText()+" "+textField_1.getText()+" "+textField_2.getText();
				Map<String, Object> data = new HashMap<String, Object>();
				System.out.println("추가할 KEY : "+key);
				data.put("add", key);
				p.setData(data);
				p.setType(300);
				getData(p);
				textField.setText(" ");
				textField_1.setText(" ");
				textField_2.setText(" ");
				
			}
		});

		buttonAdd.setBounds(547, 237, 91, 41);
		getContentPane().add(buttonAdd);

		JButton buttonStore = new JButton("매장 보기");
		buttonStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("매장보기 버튼 활성화");
				p = new Protocol();
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("init", "No");
				p.setData(data);
				p.setType(100);
				getData(p);
			}
		});
		buttonStore.setBounds(111, 263, 91, 41);
		getContentPane().add(buttonStore);

		JButton button = new JButton("삭제");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("삭제 버튼 활성화");
				String key = list.getSelectedValue().toString();
				deleteKey=key;
				
				int index = list_1.getSelectedIndex();
				String temp = key + " " + String.valueOf(index);
				System.out.println("보내기 전 : " + temp);

				p = new Protocol();

				Map<String, Object> data = new HashMap<String, Object>();
				data.put("delete", temp);
				p.setData(data);
				p.setType(200);
				getData(p);

			}
		});
		button.setBounds(379, 263, 91, 41);
		getContentPane().add(button);

		list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("선택됨");
				String key = list.getSelectedValue().toString();
				addList(key);
				getContentPane().repaint();

			}
		});

		list.setBounds(112, 44, 91, 197);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(list);

		list_1 = new JList();
		list_1.setBounds(337, 44, 170, 197);
		getContentPane().add(list_1);
		
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String key = list.getSelectedValue().toString();
				textField.setText(map.get(key).get(list_1.getSelectedIndex()).getProductName());
				textField_1.setText(String.valueOf(map.get(key).get(list_1.getSelectedIndex()).getNumber()));
				textField_2.setText(String.valueOf(map.get(key).get(list_1.getSelectedIndex()).getPrice()));
				getContentPane().repaint();

			}
		});


		JLabel lblNewLabel = new JLabel("매장");
		lblNewLabel.setFont(new Font("돋움", Font.PLAIN, 20));
		lblNewLabel.setBounds(137, 10, 46, 33);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(547, 52, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(547, 118, 116, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(547, 187, 116, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("품명");
		label.setFont(new Font("굴림", Font.PLAIN, 15));
		label.setBounds(547, 33, 57, 15);
		getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("수량");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(547, 103, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("가격");
		label_1.setFont(new Font("굴림", Font.PLAIN, 15));
		label_1.setBounds(547, 173, 57, 15);
		getContentPane().add(label_1);
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("수정 버튼 활성화");
				String key = list.getSelectedValue().toString();
				updateKey=key;
				int index = list_1.getSelectedIndex();
				p = new Protocol();
				key= key+" "+String.valueOf(index)+" "+textField.getText()+" "+textField_1.getText()+" "+textField_2.getText();
				Map<String, Object> data = new HashMap<String, Object>();
				
				System.out.println("추가할 KEY : "+key);
				data.put("update", key);
				p.setData(data);
				p.setType(400);
				getData(p);
				textField.setText(" ");
				textField_1.setText(" ");
				textField_2.setText(" ");
				
			}
		});
		btnNewButton.setBounds(547, 299, 91, 41);
		getContentPane().add(btnNewButton);

		this.setVisible(true);

	}
	
	public void addList(String key) {
		List<Stock> stockList = (ArrayList) map.get(key);
		DefaultListModel model = new DefaultListModel();
		
		if(stockList.size()==0){
			list_1.setModel(model);
		}
				
		for (int i = 0; i < stockList.size(); i++) {
			model.addElement(stockList.get(i));
			list_1.setModel(model);
		}
	}

	public void getData(Protocol p) {
		try {
			writer.writeObject(p);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// receiver가 받은 값을 리스트에 출력하는 메서드

	public class Receiver implements Runnable {
		private Socket socket;
		String temp;
		// socket의 경우는 외부에서 받아서 사용

		public Receiver(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			
			
			String temp;
			// 데이터를 소켓으로부터 읽어오기 위해서 스트림을 얻어옴
			
			try {
				reader = new ObjectInputStream(socket.getInputStream());
				while(true) {
					Protocol inp;
					
					inp = (Protocol) reader.readObject();
					System.out.println("타입 : " + inp.getType());

					if (inp.getType() == 100) {
						System.out.println("타입 : " + inp.getType());
						map = (HashMap<String, List<Stock>>) inp.getData().get("init");

						DefaultListModel model = new DefaultListModel();
						Iterator itr = map.keySet().iterator();
						while (itr.hasNext()) {
							// 오브젝트스트림써야함
							temp = (String) itr.next();
							model.addElement(temp);
							list.setModel(model);
						}
					} 
					
					else if (inp.getType() == 200) {
						System.out.println("타입!!!!!!!!!!!!!!!!!! : " + inp.getType());
						map = (HashMap<String, List<Stock>>) inp.getData().get("delete");
				
						DefaultListModel model = new DefaultListModel();
						Iterator itr = map.keySet().iterator();
						while (itr.hasNext()) {
							// 오브젝트스트림써야함
							temp = (String) itr.next();
							model.addElement(temp);
							list.setModel(model);

						}
						
						list.setSelectedValue(deleteKey, true);
						addList(deleteKey);//list_1출력
					}else if(inp.getType() == 300) {
						map = (HashMap<String, List<Stock>>) inp.getData().get("add");
						DefaultListModel model = new DefaultListModel();
						Iterator itr = map.keySet().iterator();
						while (itr.hasNext()) {
							// 오브젝트스트림써야함
							temp = (String) itr.next();
							model.addElement(temp);
							list.setModel(model);

						}
						list.setSelectedValue(addKey, true);
						addList(addKey);//list_1출력
						
					}else if(inp.getType() == 400) {
						map = (HashMap<String, List<Stock>>) inp.getData().get("update");
						DefaultListModel model = new DefaultListModel();
						Iterator itr = map.keySet().iterator();
						while (itr.hasNext()) {
							// 오브젝트스트림써야함
							temp = (String) itr.next();
							model.addElement(temp);
							list.setModel(model);

						}
						list.setSelectedValue(updateKey, true);
						addList(updateKey);//list_1출력
						
					}
				}
			}
				catch (IOException | ClassNotFoundException e) {
					System.out.println("상대방이 연결을 종료했습니다.");
					e.printStackTrace();
				}
			
		}
	}
}
