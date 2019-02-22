package com.gdatacloud.tomcat;

import java.io.OutputStream;

import lombok.Data;

@Data
public class Response {

	private OutputStream outputStream;
	// http默认成功的响应
	public static final String responseHeader = "HTTP/1.1 200 \r\n"
			+ "Content-Type: text/html\r\n"
			+ "\r\n";
	
	public Response(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	
	
}
