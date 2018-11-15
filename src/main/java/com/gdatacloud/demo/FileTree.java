package com.gdatacloud.demo;

import java.io.File;

import com.gdatacloud.ZLog;

public class FileTree {

	/**
	 * 根据传入的目录，遍历输出文件及目录树
	 * @param pathName 给定路径
	 * @param level 当前File的层级数
	 */
	public void echoTree(File parentFile, String prefix, int level) {
		ZLog.println(prefix, parentFile.getName());
		// 第一个缩进符号替换成竖线，第二个替换成空格
		prefix = prefix.replace("├", "│");
		prefix = prefix.replace("└", " ");
		
		// 需要传入一个给定的目录；File类是java.io包下的代表与平台无关的文件和目录
		if (!parentFile.exists() || parentFile.isFile()) {
//			ZLog.println("传入的参数不是目录");
			return;
		}
		// 获取所有文件并进行遍历
		File[] childFileList = parentFile.listFiles();
		for (int i = 0; i < childFileList.length; i++) {
			File f = childFileList[i];
			
			// 根据level值确定要输入几段缩进
			// 如果是最后一条，那么是└，否则就是├
			if (i == childFileList.length -1) {
				echoTree(f, prefix + "└", level + 1);
			} else {				
				echoTree(f, prefix + "├", level + 1);
			}
		}
	}
	/**
	 * 使用方法重载的方式以实现默认值
	 * @param pathName
	 */
	public void echoTree(File parentFile, String prefix) {
		echoTree(parentFile, prefix, 0);
	}
	
	public static void main(String[] args) {
		new FileTree().echoTree(new File("D:\\Core\\source\\gupaoedu-mvcframework\\src"), "");
	}
}
