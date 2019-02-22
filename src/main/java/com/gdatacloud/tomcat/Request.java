package com.gdatacloud.tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import lombok.Data;

@Data
public class Request {
	
	private String method;
	private String url;

	public Request(InputStream inputStream) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String[] headers = bufferedReader.readLine().split(" ");
		this.method = headers[0];
		this.url = headers[1];
	}
}
