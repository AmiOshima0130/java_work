//受け取るデータなし、返すデータあり　のメソッド
//return文が実行されると呼び出し側に値を直ぐに返すので、その後の処理は一切実行されません。
//したがって、何か処理を記述すると「到達不能なエラー」となります

//　public static 戻り値のデータ メソッド名() {
//	　メソッド内で実行したい処理;
//	　return 返すデータ;
//　}

package method;

import java.util.Random;

public class Method3 {

	//メソッドの定義
	public static int getNumber() {
		Random rand = new Random();
		
		//求めた乱数を呼び出し側に返す
		//0から10の乱数が返される
		return rand.nextInt(11);
	}
	
	//メソッドを実行し、返された値を変数に代入
	//メソッドを実行し、何かデータが返ってくる場合、その値を変数に代入する必要があります
	public static void main(String[] args) {
		//この1行は変数「number」に「=」の右にあるデータを代入する処理です。この時、代入するデータとしてメソッド「getNubmer()」が記述されているので、まずこのメソッドを実行します。
		int number = getNumber();
		
		System.out.println(number);

	}

}
