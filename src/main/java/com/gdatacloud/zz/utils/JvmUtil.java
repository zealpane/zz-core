package com.gdatacloud.zz.utils;

import java.io.OutputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class JvmUtil {

	public static void jstack(OutputStream outputStream) {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		for (ThreadInfo threadInfo : threadMXBean.dumpAllThreads(true, false)) {
			
		}
				
	}
	
	public static String getThreadDumpString(ThreadInfo threadInfo) {
		return null;
	}
}
