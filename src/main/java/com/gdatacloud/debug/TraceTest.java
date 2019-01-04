package com.gdatacloud.debug;

public class TraceTest {

	Object o1 = new Object();
	Object o2 = new Object();
	
	public void func1() {
		synchronized(o1) {
			func2();
		}
	}
	
	public void func2() {
		synchronized(o2) {
			try {
				CallStack.printCallStatck();
				Thread.sleep(1111111);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		TraceTest t = new TraceTest();
		t.func1();
	}
}
