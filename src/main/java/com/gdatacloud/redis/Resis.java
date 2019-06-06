package com.gdatacloud.redis;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Resis {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(6375);
		Socket socket = server.accept();
		byte[] result = new byte[2048];
		socket.getInputStream().read(result);
		System.out.println(new String(result));
	}
}
