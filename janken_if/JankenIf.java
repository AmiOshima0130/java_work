//模範解答
package janken_if;

import java.util.Random;
import java.util.Scanner;

public class JankenIf {

	public static void main(String[] args) {

		// ユーザの手をキーボードから入力してもらう
		int user = getUser();

		// コンピュータの手を乱数で作成する
		int pc = getPc();

		// 勝敗の判定を行う
		String result = judgeJanken(user, pc);

		// 結果を表示する
		showResult(user, pc, result);
	}

	public static int getUser() {
		// キーボード入力の準備
		Scanner stdin = new Scanner(System.in);

		// 無限ループ→ユーザーが何度も間違えるかもしれないから。
		while (true) {
			// メッセージの表示
			System.out.println("あなたのじゃんけんの手を入力して下さい");
			System.out.print("(グー：0，チョキ：1、パー：2)　--> ");

			// 入力されたデータが整数かどうかのチェック
			if (stdin.hasNextInt()) {
				// 入力されたデータを整数として読み込む
				int number = stdin.nextInt();
				// 整数でも有効なのは「0，1，2」のみ
				if (number <= -1 || number >= 3) {
					// 範囲外は無効なデータなのでやり直し
					System.out.println("【エラー】入力できるのは「0～2」です");
					continue;//それ以降の処理を無視して、繰り返しの先頭にもどる
				} else {
					// 0,1,2の場合、メソッドの結果として返す
					return number;
				}
			} else {
				// 整数以外の場合、無効なデータなのでやり直し
				System.out.println("【エラー】入力できるのは整数だけです");
				// 不要なトークンをバッファから取り除く
				stdin.next();//next()メソッドは、入力から次のトークン（単語や数字などの区切られた要素）を読み取ります
			}
		}
	}

	public static int getPc() {
		// 乱数の準備
		Random rand = new Random();
		// 0,1,2のどれかを求め、メソッドの結果として返す
		return rand.nextInt(3);//0から始まる3種類の整数
	}

	public static String judgeJanken(int user, int pc) {
		String result = ""; // 判定結果を保存する

		if ((user == 0 && pc == 1) || (user == 1 && pc == 2) || (user == 2 && pc == 0)) {
			result = "勝ち";
		} else if ((user == 0 && pc == 2) || (user == 1 && pc == 0) || (user == 2 && pc == 1)) {
			result = "まけ";
		} else {
			result = "あいこ";
		}

		// 勝敗結果を返す
		return result;
	}

	public static void showResult(int user, int pc, String result) {
		// 文字列で表示したいので、じゃんけんの手を配列で定義
		//配列の添え字は「0」から始まるので、添え字「0」には「グー」、添え字「1」には「チョキ」、添え字「2」には「パー」の文字列を保存します。
		//添え字とじゃんけんの手を表す値が一致するようにします。
		String[] janken = { "グー", "チョキ", "パー" };
		// 結果の表示	　jankenという配列から、userという変数が指し示す位置の要素を取得
		System.out.println("あなたの手:" + janken[user] + ",コンピュータの手:" + janken[pc]);
		System.out.println("結果：" + result);
	}

}
