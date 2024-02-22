package test02;

class User {//銀行を想定
	//扱う値を定義
	String name;//名前
	int bank_branch;//支店番号
	int bank_number;//口座番号
	int bank_balance;//口座残高

	User(String name, int bank_branch, int bank_number, int bank_balance){//コンストラクタ
		this.name = name;
		this.bank_branch = bank_branch;
		this.bank_number = bank_number;
		this.bank_balance = bank_balance;
	}
	//ユーザー情報（名前、支店番号、口座番号）を出力するメソッドを書く
	String getUserInfo() {
		return this.name + "," + bank_branch + "," + bank_number; 
	}
	
	//口座残高を出力するメソッドを描く
	String printBankBalance() {
		return this.bank_balance + "円";
	}
	
	//口座残高を10000円増やすメソッドを書く
	void plusBankBalance() {//返り値がないものはvoid
		this.bank_balance = this.bank_balance + 10000;
	}
}

public class sample {//メインのクラスはここですよという箱
	public static void main(String[] args) {
		User myData = new User("Ami", 100, 12345, 5000);
		System.out.println(myData.getUserInfo());
		System.out.println(myData.printBankBalance());
		myData.plusBankBalance();
		System.out.println(myData.printBankBalance());
	}
}