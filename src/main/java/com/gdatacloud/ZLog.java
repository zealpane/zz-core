package com.gdatacloud;

/**
 * 自定义日志输出，方便根据开发环境切换是否输出或者改变输出工具类
 * 生产环境中，不能使用System.out.print，因为print方法调用的write方法是synchronized的，在多个线程并发时效率很低
 * @author 泽朋
 *
 */
public class ZLog {

	public static void print(Object... obj) {
		for (Object object : obj) {
			System.out.print(object);
		}
	}
	
	public static void println(Object... obj) {
		for (Object object : obj) {
			System.out.print(object);
		}
		System.out.println();
	}
}
