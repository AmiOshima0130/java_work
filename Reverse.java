package com.design_shinbi.exercise;

public class Reverse {
	public static String reverse(String s) {
		String reversed = "";

		if (s.length() <= 1) {
			reversed = s;
		} else {
			String head = s.substring(0, 1); // 1文字目
			String body = s.substring(1); // 2文字目以降
			reversed = reverse(body) + head;
		}

		return reversed;
	}

	public static void main(String[] args) {
		String[] sources = { "abcde", "akasaka", "a", "シンビデザインスクール" };

		for (int i = 0; i < sources.length; i++) {
			String s = sources[i];
			String reversed = Reverse.reverse(s);

			System.out.println("元の文字列: " + s);
			System.out.println("反転文字列: " + reversed);
		}
	}
}
