//仕様
//グーは「0」、チョキは「１」、パーは「2」で表現する
//ユーザのじゃんけんの手は、キーボードから入力してもらう
//「0」「1」「2」以外のデータが入力された時は、再入力させる
//コンピュータ側のじゃんけんの手は、乱数で自動的に求める
//ユーザの判定結果(勝ち、負け、引き分け)を画面に表示する
//メソッドを利用して作成する

//自作したもの
package if_janken;

import java.util.Random;
import java.util.Scanner;

public class IfJanken {

	public static void main(String[] args) {
		//フィールド定義
		//ユーザー側のじゃんけんの手を求める(入力させる)
		//pc側のじゃんけんの手を求める(乱数をつくる)
		int userHand = getUser();
		int pcHand = getPc();

		//ユーザーの勝敗を判定する
		String result = judgeJanken(userHand, pcHand);

		//結果を表示する
		IfJanken game = new IfJanken();
		game.showResult(userHand, pcHand, result);
	}

	//メソッドをつくる
	public static int getUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ユーザーのじゃんけんの手を入力してください (0: グー, 1: チョキ, 2: パー");

		int userInput = scanner.nextInt();
		String message;

		// 入力値が0, 1, 2以外の場合は再入力
		while (userInput < 0 || userInput > 2) {
			System.out.println("無効な番号です。もう一度入力してください。");
			userInput = scanner.nextInt();
		}

		return userInput;
	}

	public static int getPc() {
		Random random = new Random();
		int randomNumber = random.nextInt(3);//0から3未満の整数を生成

		return randomNumber;
	}

	public static String judgeJanken(int userHand, int pcHand) {
		String result = null;

		while (userHand == pcHand) {
			System.out.println("あいこです。もう一度じゃんけんをします.");

			Scanner scanner = new Scanner(System.in);
			System.out.println("ユーザーのじゃんけんの手を入力してください (0: グー, 1: チョキ, 2: パー");

			int userInput = scanner.nextInt();

			// 入力値が0, 1, 2以外の場合は再入力
			while (userInput < 0 || userInput > 2) {
				System.out.println("無効な番号です。もう一度入力してください。");
				userInput = scanner.nextInt();
			}

			String message;

			switch (userInput) {
			case 0:
				message = "グー";
				break;
			case 1:
				message = "チョキ";
				break;
			case 2:
				message = "パー";
				break;
			default:
				message = "無効な番号です。もう一度入力してください。";
			}
			result = message;
		}

		if ((userHand == 0 && pcHand == 1)
				|| (userHand == 1 && pcHand == 2)
				|| (userHand == 2 && pcHand == 0)) {
			System.out.println("あなたの勝ちです");
			result = "あなたの勝ちです";
		} else if ((userHand == 0 && pcHand == 2)
				|| (userHand == 1 && pcHand == 0)
				|| (userHand == 2 && pcHand == 1)) {
			System.out.println("あなたの負けです");
			result = "あなたの負けです";
		} else {
			result = null;
		}

		return result;
	}

	public void showResult(int userHand, int pcHand, String result) {
		System.out.println("ユーザーの手: " + userHand);
		System.out.println("PCの手: " + pcHand);
		System.out.println("結果: " + result);
	}

}
