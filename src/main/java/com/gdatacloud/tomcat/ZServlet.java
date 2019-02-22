package com.gdatacloud.tomcat;

import javax.servlet.ServletConfig;

/**
 * 自定义的servlet
 * @author 泽朋
 *
 */
public interface ZServlet {

	void init(ServletConfig servletConfig);
	
	void service(Request req, Response res);
	
	void destroy();
}
