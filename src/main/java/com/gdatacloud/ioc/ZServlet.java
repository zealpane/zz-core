package com.gdatacloud.ioc;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.gdatacloud.ioc.Annotation.ZController;
import com.gdatacloud.ioc.Annotation.ZRequestMapping;
import com.gdatacloud.ioc.Annotation.ZService;

public class ZServlet extends HttpServlet {

	private List<String> classNames = new ArrayList<>();
	private Map<String, Object> ioc = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		// 加载配置
		
		// 扫描所有相关的类
		
		// 初始化刚刚扫描的类，并把它保存到IOC容器之中
		
		// 实现依赖注入、DI、自动赋值
		
		// 初始化HandlerMapping
	}
	
	private void initHandlerMappint() {
		if (ioc.isEmpty()) { return; }
		for (Map.Entry<String, Object> entry : ioc.entrySet()) {
			Class<?> clazz = entry.getValue().getClass();
			if (!clazz.isAnnotationPresent(ZController.class)) {
				continue;
			}
			String baseUrl = "";
			if (clazz.isAnnotationPresent(ZRequestMapping.class)) {
				ZRequestMapping requestMapping = clazz.getAnnotation(ZRequestMapping.class);
				baseUrl = requestMapping.getValue();
				continue;
			}
			
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				if (!method.isAnnotationPresent(ZRequestMapping.class)) {
					
				}
			}
		}
	}
	
	private void doAutowired() {
		if (ioc.isEmpty()) {
			return;
		}
		for (Entry<String, Object> entry : ioc.entrySet()) {
			Field[] fields = entry.getValue().getClass().getDeclaredFields();
			for (Field field : fields) {
				
			}
		}
	}
	
	private void doInstance() {
		if (classNames.isEmpty()) { return; }
		try {
			for (String className : classNames) {
				Class<?> clazz = Class.forName(className);
				
				if (clazz.isAnnotationPresent(ZController.class)) {
					Object instance = clazz.newInstance();
					String beanName = lowerFirstCase(clazz.getSimpleName());
					ioc.put(beanName, instance);					
				} else if (clazz.isAnnotationPresent(ZService.class)) {
					
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private String lowerFirstCase(String string) {
		char[] chars = string.toCharArray();
		return null;
	}

	private void doScanner(String scanPackage) {
		URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("", ""));
		
		File classDir = new File(url.getFile());
		
		for (File f : classDir.listFiles()) {
			if (f.isDirectory()) {
				doScanner(scanPackage + "." + f.getPath());
			} else {
				
			}
		}
	}
}
