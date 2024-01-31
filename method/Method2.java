//受け取るデータあり、返すデータなしのメソッド
package method;

public class Method2 {

	//メソッドの定義
	//受け取ったデータを保存する変数の情報をshowHello()の()内に記述しています
	//メソッドを実行しても何も呼び出し側(8行目)には返さないので「void」と記述しています
	public static void showHello(int count) {
		
		//指定された回数、表示処理を繰り返す
		for (int i = 0; i< count; i++) {
			System.out.println("Hello World");
		}
	}
	
	public static void main(String[] args) {
		//値を渡して、定義したメソッドの実行
		//表示する回数をメソッドに渡すので、メソッド名の()内に渡したいデータを直接記述しています。
		//このメソッドを実行しても何もデータが返されないので、メソッド名だけを記述します
		showHello(3);

	}

}
