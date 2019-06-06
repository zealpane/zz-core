package com.gdatacloud.f;

import org.junit.Test;

// 观察，推想，验证
public class T1 {

	public void a() {
		int m = 4, n = 3;
		
		// 第一行要输入的值
		int[] first = {m, n};
		// 随后输入的值，有n行
		int[] rowVal = {3, 4, 5};
		
		// 要能组合出1到m之间的所有面值；比如如果m是9，那么携带的硬币要能组合成1到9的所有数字；现在的题目就转换成了排列组合：先从1开始

		// 首先判断数组第一位是否是1，如果不是，那么不符合题意，无解
		if (rowVal[0] != 1) {
			System.out.println(-1);
		}
		
		// 这个地方是否牵扯一些数学公式是我不记得的呢
		// 要追寻结果，结果就是要携带尽量少的硬币；可以根据结果推，在此声明硬币组合
		int[] ym = new int[m];
		
		// 从小到大，找出所有数据；后续的计算中尽量多利用已用的数据组合
		for (int i = 1; i <= m; i++) {
			for (int j : rowVal) {
				if (j < m) {
					
				} else {
					System.out.println("结束");
				}
			}
		}
		
		// 思路梳理：可以先看现有元素数量；
		
		// 思路梳理：如果元素有2，那么
		// 此处先假设rowVal已经是排过序的数组，如果乱序那么排序；从第一位开始与m比较，如果小于m，那么进入下一层；如果大于等于m，那么停止
		for (int i : rowVal) {
			if (i < m) {
				
			} else {
				System.out.println("结束");
			}
		}
		
	}
	@Test
	public void b() {
		int length = 4;
		String str = "11001010111000";
		
		// 从题干上来看,这个地方因为牵扯到消除操作,可以考虑链表；但是又因为是字符串，字符串有截取方式所以可以不用了
		
		for (int i = 0; i < str.length(); i++) {
			// 先从第一位开始，每一次循环都和后面比较
			if (str.charAt(i) != str.charAt(i + 1)) {
				str = str.substring(0, i) + str.substring(i+2);
				if (str.length() >= 2) {
					// 然后再从下标i-1开始判断，封装一个函数，传入参；这儿还需要再对当前下标的位置做判断，否则不行
					str = b2(i-1, str);					
				}
			}
		}
		System.out.println("长度" + str.length());
	}
	
	String b2(int index, String str) {
		System.out.println("index: " + index);
		System.out.println("str: " + str);
		for (int i = index; i < str.length(); i++) {
			// 先从第一位开始，每一次循环都和后面比较
			if (str.charAt(i) != str.charAt(i + 1)) {
				if (str.length() == 2) {
					str = "";
					return str;
				}
				str = str.substring(0, i - 1) + str.substring(i+2);					
				if (str.length() >= 2) {
					// 然后再从下标i-1开始判断，封装一个函数，传入参
					b2(i-1, str);					
				}
			}
		}
		return str;
	}
}
