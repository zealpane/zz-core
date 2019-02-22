package com.gdatacloud.tomcat;

/**
 * 专门处理http的servlet类
 * @author 泽朋
 *
 */
public abstract class HttpZServlet implements ZServlet {

	public void service(Request req, Response res) {
		if ("get".equalsIgnoreCase(req.getMethod())) {
			this.doGet(req, res);
		} else {
			this.doPost(req, res);
		}
	}
	
	public abstract void doGet(Request req, Response res);
	
	public abstract void doPost(Request req, Response res);
	
}
