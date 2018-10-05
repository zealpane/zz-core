package com.gdatacloud.zz.classLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class MyClassLoaderTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		StringBuffer classLinkStr = new StringBuffer("(");
		
		File file = new File(".");
		InputStream inputStream = new FileInputStream(file.getCanonicalPath() + "\\target\\classes\\com\\gdatacloud\\zz\\Programmer.class");
		
		byte[] result = new byte[1024];
		
		int count = inputStream.read(result);
		// use custom classloader to convert
		MyClassLoader classLoader = new MyClassLoader();
		Class clazz = classLoader.defineMyClass(result, 0, count);
		// 测试类是否加载成功
		System.out.println(classLinkStr.append(clazz.getSimpleName()).append(".java:1)"));
		Object o = clazz.newInstance();
		clazz.getMethod("code", null).invoke(o, null);
	}
}
