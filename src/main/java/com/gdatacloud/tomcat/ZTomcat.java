package com.gdatacloud.tomcat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ZTomcat {

	public static Map m = new HashMap<String, Object>();
	
	/**
	 * 初始化
	 */
	public void init() {
		m.put("/login", new LoginHttpServlet());
	}
	
	public void start() {
		try {
			ServerSocket serverSocket = new ServerSocket(1500);
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println(socket);
				Thread t = new ServerThread(socket);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ZTomcat t = new ZTomcat();
		t.init();
		t.start();
	}
}
