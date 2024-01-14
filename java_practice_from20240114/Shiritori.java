package java_practice_from20240114;

import java.util.Scanner;

public class Shiritori {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("文字を入力してください");
		
		String inputString = scanner.nextLine();
		
		while(true) {
			String getLastWord = inputString.substring(inputString.length() - 1);
			System.out.println("しりとりの単語: " + getLastWord);
			System.out.println("文字を入力してください");
			String input = scanner.nextLine();
			
			if(!getLastWord.equals(input.substring(0, 1))) {
				System.out.println("しりとりが続けられません");
				break;
			}
			inputString = input;
		}
		scanner.close();
	}
		
}
