package consolQuiz;

import java.util.Scanner;

public class SimpleGame {

	
	
	//メインで実行されるクラス
	public static void main(String[] args) {
		
		//クイズの質問を表示する
		System.out.println("アメリカの首都はどこですか？");
		System.out.println("1:ニューヨーク");
		System.out.println("2:ワシントン");
		System.out.println("3:ロサンジェルス");
		
		//userInputを実行させる
		SimpleGame input = new SimpleGame();
		//userInputメソッドの結果を変数に保存
		int userAnswer = input.userInput();
		
		//正解です・不正解ですと表示させたい
		SimpleGame answer = new SimpleGame();
		//alertAnswerメソッドを呼び出して、それはuserInputの値を持っている
		String result = answer.alertAnswer(userAnswer);
		
		System.out.println(result);
	}
	
	//ユーザーに入力させるメソッド
	//1から3までの数字が有効です。それ以外は受け付けません。
	public int userInput() {
		Scanner scanner = new Scanner(System.in);
		int input;
		
		//答えの番号を入力する支持を表示する
		System.out.println("答えを番号で入力し、改行を押してください。＝＞");
		
		//条件が常に true であるため、プログラムがこの部分に到達すると無限に繰り返される
		while(true) {
			
			if(scanner.hasNextInt()) {//入力されたデータが整数かどうかのチェック
				input = scanner.nextInt();//整数の入力がinputに入る
				
				//もし、入力された値が1～3だったら、ループを抜ける
				if(input ==1 || input == 2 || input == 3) {
					break;
				} else if(input < 1 || input > 3) {
					System.out.println("1から3までの数字を入力。");
				}
			} else {
				System.out.println("1から3までの整数を入力してください。");
			}
		}
			
		return input;	
	}
	
	//正解です・不正解ですと表示するメソッド
	//2が入力されたら正解です・それ以外は不正解です
	public String alertAnswer(int userInput) {
		if(userInput == 2) {
			return "正解です";
		} else if (userInput == 1 || userInput == 3) {
			return "不正解です";
		} else {
			return "不正解です";
		}
	}
}
	
	
	

