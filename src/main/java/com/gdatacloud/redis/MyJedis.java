package com.gdatacloud.redis;

import java.io.IOException;
import java.net.Socket;

public class MyJedis {

	public static String set(Socket socket, String key, String value) throws IOException {
		StringBuffer sb = new StringBuffer();
		sb.append("*3").append("\r\n");
		sb.append("$3").append("\r\n");
		sb.append("SET").append("\r\n");
		
		sb.append("$").append(key.getBytes().length).append("\r\n");
		sb.append(key).append("\r\n");
		
		sb.append("$").append(value.getBytes().length).append("\r\n");
		sb.append(value).append("\r\n");
		
		socket.getOutputStream().write(sb.toString().getBytes());
		
		byte[] response = new byte[2048];
		socket.getInputStream().read(response);
		
		return new String(response);
	}
	public static String get(Socket socket, String key) throws IOException {
		StringBuffer sb = new StringBuffer();
		sb.append("*3").append("\r\n");
		sb.append("$3").append("\r\n");
		sb.append("SET").append("\r\n");
		
		sb.append("$").append(key.getBytes().length).append("\r\n");
		sb.append(key).append("\r\n");
		
		socket.getOutputStream().write(sb.toString().getBytes());
		
		byte[] response = new byte[2048];
		socket.getInputStream().read(response);
		
		return new String(response);
	}
	
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("192.168.167.179", 6379);
		set(socket, "name", "zzp");
		System.out.println(1 + get(socket, "name"));
	}
}
