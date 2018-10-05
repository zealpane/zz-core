package com.gdatacloud.zz.classLoader;

import aj.org.objectweb.asm.ClassWriter;
import aj.org.objectweb.asm.MethodVisitor;
import aj.org.objectweb.asm.Opcodes;

public class AsmGenerator {

	public static void main(String[] args) {
		ClassWriter classWriter = new ClassWriter(0);
		// 通过visit方法确定类的头部信息
		classWriter.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, "Programmer", null, "java/lang/Object", null);
		
		// 创建构造函数
	}
}
