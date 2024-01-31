package method;
//受け取るデータなし、返すデータなし　のメソッド
public class Method1 {
	
	//メソッドの定義
	//データは何も受け取らないので、showHello()の()内には何も記述していません。
	//このメソッドを実行しても何も呼び出し側(8行目)には返さないので「void」と記述しています。
	public static void showHello() {
		System.out.println("Hello World");
	}
	
	//データは何も渡さないのでメソッド名の()内には何もデータを記述しません。
	//このメソッドを実行しても何もデータが返されないので、メソッド名だけを記述します(8行目)。
	public static void main(String[] args) {
		//定義したメソッドの実行
		showHello();
	}
}
