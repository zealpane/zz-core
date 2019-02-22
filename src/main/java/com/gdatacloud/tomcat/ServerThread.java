package com.gdatacloud.tomcat;

import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread {

	protected Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			Request request = new Request(socket.getInputStream());
			Response response = new Response(socket.getOutputStream());
			System.out.println(request);
			HttpZServlet httpZServlet = (HttpZServlet) ZTomcat.m.get(request.getUrl());
			if (httpZServlet != null) {				
				httpZServlet.service(request, response);
			} else {
				System.out.println("无对应servlet");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
