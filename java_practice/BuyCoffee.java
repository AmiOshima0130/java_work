package java_practice;

import java.util.Scanner;

class PresentCoffee {
	int storage;//クラス内のメンバ変数＝フィールド
	
	PresentCoffee(int storage) {//コンストラクタ：クラスのインスタンスが作成される
		this.storage = storage;//度に呼び出され、引数としてstorageが渡される
	}
}

class PresentCoffeeAlert {
	void displayPresentCoffeeAlert(int storage) {//メソッド宣言。
		if (storage < 2) {//在庫数に応じて異なるアラートをする
			System.out.println("コーヒーを買ってください");
		} else if (storage >= 13) {
			System.out.println("在庫数の上限を超えています");
		} else if (storage == 12) {
			System.out.println("コーヒーは満タンです");
		} else {
			System.out.println("コーヒーは買わなくて平気です");
		}
	}
}

class BuyCoffeeAlert {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("在庫数を入力してください");
		int inputStorage = scanner.nextInt();
		//PresentCoffeeクラスのインスタンス作成。入力値をコンストラクタに渡して在庫数が初期化。
		PresentCoffee presentCoffee = new PresentCoffee(inputStorage);
		//PresentCoffeeAlertクラスのインスタンス作成。
		//displayPresentCoffeeAlertメソッドを呼び出し、
		//PresentCoffeeインスタンスの在庫数を引数として渡す
		PresentCoffeeAlert presentCoffeeAlert = new PresentCoffeeAlert();
		presentCoffeeAlert.displayPresentCoffeeAlert(presentCoffee.storage);
	}
}