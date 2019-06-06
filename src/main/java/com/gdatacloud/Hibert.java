package com.gdatacloud;

public class Hibert {

	public static void main(String[] args) {
		int[][] r = new int[4][4];
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {
				// System.out.print("(" + i + ":" + j + ")");
				r[i][j] = i + j + 1;
				System.out.print("1/" + r[i][j] + " ");
			}
			System.out.println();
		}
	}
}
