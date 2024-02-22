package diceTyouhan;

import java.util.Scanner;

//メインのクラス
public class diceTyouhan {

	//賭ける金額を入力させるクラス
	class inputBetMoney {
		private int havingMoney;
		private int betMoney;
		private Scanner scanner;

		inputBetMoney(int havingMoney) {
			this.havingMoney = havingMoney;
			this.scanner = new Scanner(System.in);
		}

		//メソッド
		public void inputBet() {
			System.out.println("所持金: " + havingMoney);
			System.out.print("賭ける金額を入力してください: ");

			//scanner.nextIntをメソッド内で呼び出し
			this.betMoney = scanner.nextInt();

			if (this.betMoney > havingMoney) {
				System.out.println("所持金を超えています");
				System.out.print("賭ける金額を入力してください: ");
				this.betMoney = scanner.nextInt();	
			} else {
				havingMoney -= this.betMoney;
			}

		public int getHavingMoney() {
			return havingMoney;
		}
	}

	public class inputBetMoney() {
			inputBetMoney inputBetMoney = new inputBetMoney();
	        inputBetMoney.inputBet();
		}
	}

	//1から6までのランダムな整数を2回生成して、それぞれのサイコロの目を取得するクラス
	class getDiceNumber {

		//ここには1から6までのランダムな整数を２回生成するさいころがある
		public static int randomInt(int min, int max) {
			double random = Math.random();
			int count = (max - min) + 1;
			int number = (int) Math.floor((double) count * random) + min;
			return number;
		}

		int dice1 = randomInt(1, 6);
		int dice2 = randomInt(1, 6);
		int diceSum = dice1 + dice2;

		//メソッド（さいころの目を取得して返す）
		public int getDiceRandomNum(int diceSum) {
			return diceSum;
		}

		//メソッド（合計が偶数だったら丁、合計が奇数だったら半を返す）
		public void tyouHan() {
			if (diceSum % 2 == 0) {
				System.out.println("丁");
			} else {
				System.out.println("半");
			}
		}
	}

	//ユーザーに丁or半を入力させる+「丁」または「半」とサイコロの結果が一致すれば勝ち、そうでなければ「負け」クラス
	class inputTyouhan {

		//フィールド
		private String userInput;
		private String diceResult;
		private Scanner scanner;

		//コンストラクタ
		inputTyouhan(String userInput) {
			this.userInput = userInput;
			this.scanner = new Scanner(System.in);
		}

		//メソッド
		public void judge() {
			System.out.println("「丁」か「半」を入力してください");

			this.userInput = scanner.nextLine();

			if (this.userInput == diceResult) {
				System.out.println("あなたの勝ちです。賭けた金額を２倍にします。");
			} else {
				System.out.println("あなたの負けです。かけた金額分を没収です。");
			}
		}
	}

	//勝ったら賭けた金額を２倍にする・負けたら賭けた金額を没収するクラス
	class money {
		private int betAmount;

		// コンストラクタ
		money(int betAmount) {
			this.betAmount = betAmount;
		}

		// 勝った場合の処理
		void win() {
			betAmount = inputBet * 2;
		}

		// 負けた場合の処理
		void lose() {
			betAmount = 0;
		}

		// 賭けた金額を取得するメソッド
		int getBetAmount() {
			return betAmount;
		}

		public class moneyMain() {
	  	moneyMain userMoney = new moneyMain(inputBet);
	  	userMoney.win();
	  	userMoney.lose();
	  }
	}

	public static void main(String[] args) {
		Tyouhan tyouhan = new Tyouhan();
		
		//メソッドの呼び出し
		tyouhan.inputBet();
		tyouhan.getDiceRandomNum();
	}
}
