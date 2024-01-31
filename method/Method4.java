//受けとるデータあり、返すデータありのメソッド
// public static 戻り値のデータ型 メソッド名 (受け取るデータ型 変数名) {
//	 メソッド内で実行したい処理;
//	 return 返すデータ;
// }
package method;

public class Method4 {

	//メソッドの定義
	public static String checkOddEven(int value) {
		
		//受け取った値が偶数かどうかのチェック
		if(value % 2 == 0) {
			return "偶数です";
		} else {
			return "奇数です";
		}
	}
	
	public static void main(String[] args) {
		String result = checkOddEven(5);
		
		System.out.println(result);

	}

}
