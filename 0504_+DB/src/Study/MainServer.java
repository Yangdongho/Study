package Study;

import java.io.IOException;

import java.net.ServerSocket;

import java.net.Socket;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

//정보 저장 및 불러오기

public class MainServer {

	public static void main(String[] args) {

		Socket socket;
		Thread t;
		try {

			ServerSocket serversocket = new ServerSocket(5000);

			while (true) { // 유저 접속시 쓰레드 생성

				socket = serversocket.accept();
				System.out.println(socket + "연결 성공");
				t = new Thread(new Server1(socket));
				t.start();
				System.out.println("서버 쓰레드 시작");
			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}