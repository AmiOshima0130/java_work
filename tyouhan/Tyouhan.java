//丁半ゲームを作る
//1.さいころを2個ふって丁半を判定する（合計が偶数：丁、奇数：半）
//2.手持ちの金をかけて負けたら掛け金没収、買ったら倍になって帰ってくる
//3.手持ちが0になるか、勝負を降りるまで繰り返す

//1.乱数を発生させる
//2.乱数を足し算する→偶数なら丁、奇数なら半
//3.ユーザーに「丁」か「半」を入力させる
//4.ユーザーに賭ける金額を入力させる
//5.ユーザーの「丁」「半」の入力と足し算結果が一致したら賭けた金額を2倍にして元々持っていた
//　金額に足す。一致しなかったら賭けた金額を元々持っていた金額から引く。
//6.「ゲームをやめますか？」とアラートして、「はい」「いいえ」を入力させる
//7.「はい」と入力されたら「ゲームオーバー」と表示する。
//8.「いいえ」と入力されたらゲームを続行する。
//9.元々持っていた金額がゼロになったら「ゲームオーバー」と表示する

//必要なもの
//さいころ1, さいころ2, 最初にもつお金, 

package tyouhan;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Tyouhan {

	//メインで実行させるクラス
	public static void main(String[] args) {

		Tyouhan tyouhan = new Tyouhan();

		//不要なメソッドは削除すること
		//		tyouhan.randomSum();
		//		tyouhan.oddOrEven();
		//		tyouhan.inputTyouHan();
		//		tyouhan.inputAmount();
		
		tyouhan.playGame();
	}

	//乱数を発生させて足し算をするメソッド
	public int randomSum() {

		Random random = new Random();

		int dice1Result = random.nextInt(6) + 1;

		int dice2Result = random.nextInt(6) + 1;

		int diceRandomSum = dice1Result + dice2Result;

		return diceRandomSum;
	}

	//diceRandomSumが偶数だったら丁、奇数だったら半と定義するメソッド
	public String oddOrEven() {
		//randomSumメソッドを呼び出して戻り値を取得する
		int judgeOddOrEven = randomSum();

		if (judgeOddOrEven % 2 == 0) {
			return "丁";
		} else {
			return "半";
		}
	}

	//ユーザーに丁か半を入力させるメソッド
	public String inputTyouHan() {
		Scanner inputTyouOrHan = new Scanner(System.in);

		System.out.println("「丁」または「半」を入力してください");

		String userInput = inputTyouOrHan.nextLine();

		while (!userInput.equals("丁") && !userInput.equals("半")) {
			System.out.println("無効な値です。「丁」または「半」を入力してください");
			userInput = inputTyouOrHan.nextLine();
		}

		return userInput;

	}

	//ユーザーに賭ける金額を入力させるメソッド
	public int inputAmount(int moneyPossesion) {
		
		Scanner inputMoneyAmount = new Scanner(System.in);
		
		//playGame()メソッドにてmoneyPossesion = updatedMoneyPossession;
		System.out.println("あなたは" + moneyPossesion + "円持っています。賭ける金額を入力してください.");

		int userMoneyInput;

		while (true) {
			try {
				userMoneyInput = inputMoneyAmount.nextInt(); // 整数で入力を求める
				if (userMoneyInput > 0 && userMoneyInput <= moneyPossesion) {
					break;//整数で入力を求める中に、不適切な金額の入力があった場合の処理を記述
				} else {
					System.out.println("所持金を超えています。もう一度掛け金を入力してください.");
				}
			} catch (InputMismatchException e) {
				System.out.println("掛け金は整数で入力してください.");
				inputMoneyAmount.next(); // 入力が整数でない場合は入力ストリームをクリアして次の入力を待つ
			}
		}
		return userMoneyInput;
	}

	//ユーザーの「丁」「半」の入力と足し算結果が一致したら賭けた金額を2倍にして元々持っていた
	//金額に足す。一致しなかったら賭けた金額を元々持っていた金額から引く。
	//所持金の増減を計算するメソッド
	public int calculateMoneyPossesion(int currentPossesion, int betMoney, String userInput, String pcInput) {
		if (userInput.equals(pcInput)) {
			return currentPossesion + 2 * betMoney;
		} else {
			return currentPossesion - betMoney;
		}
	}

	//丁半ゲームをプレイさせるメソッド
	public void playGame() {
		int moneyPossesion = 1000;
		
		while(moneyPossesion > 0) {
			 String pcInput = oddOrEven();
	         String userInput = inputTyouHan();
	         int betMoney = inputAmount(moneyPossesion);
	         
	         int updatedMoneyPossession = calculateMoneyPossesion(moneyPossesion, betMoney, userInput, pcInput);
	         
	         moneyPossesion = updatedMoneyPossession;
	         
	         if (updatedMoneyPossession == 0) {
	             System.out.println("所持金が0円になりました。ゲームオーバー。");
	             break;//ここで処理終わり
	         } else {
	             System.out.println("現在の所持金: " + moneyPossesion + "円");
	             System.out.println("次のゲームを続行しますか？（はい/いいえ）");

	             Scanner scanner = new Scanner(System.in);
	             String continueGame = scanner.nextLine();

	             if (!continueGame.equalsIgnoreCase("はい")) {
	                 System.out.println("ゲームを終了します。");
	                 break;//ここで処理終わり
	             } else {}	
	         }
		}
	}
}
