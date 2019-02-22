package com.gdatacloud.tomcat;

import java.io.OutputStream;

import javax.servlet.ServletConfig;

public class LoginHttpServlet extends HttpZServlet {

	@Override
	public void init(ServletConfig servletConfig) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doGet(Request req, Response res) {
		this.doPost(req, res);
	}

	@Override
	public void doPost(Request req, Response res) {
		try {
			OutputStream outputStream = res.getOutputStream();
			String resText = Response.responseHeader + "hello!";
			outputStream.write(resText.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
