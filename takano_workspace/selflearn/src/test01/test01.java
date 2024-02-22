//package test01;//「test01のコードです」

//public class test01 {

	//public static void main(String[] args) {
//		System.out.print("数字を入力してください");
//		int num = new Scanner (System.in).nextInt();//new以下は「入力された文字を数字として出力する。」
//		                                            //numには毎回数字が入る。
//		System.out.println(num);
		
		//System.out.print("信号機の色は？");
		//String signal = new Scanner (System.in).next();
		//if (signal.equals("red") == true) {
			//System.out.println("Stop");
		//} else {
			//System.out.println("Not Red");
			
			//switch(signal) {
			//case "red":
			//case "赤":
			//case "あか":
				//System.out.println("とまれ");
				//break;
			//case "blue":
			//case "青":
			//case "あお":
				//System.out.println("進め");
				//break;
			//case "yellow":
			//case "黄色":
			//case "きいろ":
				//System.out.println("行け");
				//break;
			//default:
				//System.out.println("とりあえず止まろう");
				//break;
			//}
			
			//for文を使って1から10の数字を出力する。
			//for (int i=1; i <= 10 ; i++) {
				//System.out.println(i);
			//}
				
		//}
	//}
	
	//条件演算子
	//public class MyApp {}
		//public static void main(String[] arge) {
			//int score = new Scanner(System.in).nextInt();
			//String result = score >= 90 ? "A!" : "B!";
			//System.out.println(result);
		//}
	
	//メソッド
	//private static int triple(int num){//仮引数
		//return num * 3;
	//}
	
	//private static int sum(int a, int b) {
		//return a + b;
	//}
	
	//public static void main(String [] args) {
		//System.out.println(triple(3));
		
		//var score = triple(100);
		//System.out.println(score);
	//}
	
	//public static void main(String[] args) {
		//var result = sum(1,2);
		//System.out.println(result);
	//}
//}

//public class test01 {
//	private static int triple(int num){//仮引数
//		return num * 3;
//	}
//	
//	private static boolean judge(int num) {
//		return num > 5 ? true : false;//三項演算子
//	}
//	
//	public static void main(String[] args) {
//		var result= judge(5);
//		if(result == true) {
//			System.out.println("true");
//		}else {
//			System.out.println("false");
//		}
//	}
//}

//public class test01 {
//	private static int triple(int num){//仮引数
//		return num * 3;
//	}
//	
//	private static boolean judge(int num) {
//		return num > 0 ? true : false;//三項演算子
//	}
//
//	private static void PrintJudge(boolean resultNum){
//		if(resultNum == true) {
//			System.out.println("true");
//		} else {
//			System.out.println("false");}
//		}	
//		
//	public static void main(String[] args) {
//		PrintJudge(judge(0));
//	}
//}
//クラスを作る
//class User {
//	String name;
//	int score;
//	int age;
//	}	
//
//public class test01{
//	public static void main(String[] args) {
//		User user1 = new User();//インスタンスができた
//		user1.name = "ami";
//		user1.score = 80;
//		user1.age = 27;
//		System.out.println(user1.name);
//		
//		User user2 = new User();
//		user2.name = "takano";
//		user2.score = 100;
//		user2.age = 99;
//		System.out.println(user2.name);
//	}
//	
//}

//コンストラクタ
//class User {
//	String name;
//	private int score;
//	int age;
//	
//	//constractor
//	User(String name, int score, int age) {
//		this.name = name;
//		this.score = score;
//		this.age = age;
//	}
//	//メソッド
//	String getUserString() {
//		return name + "," + score;
//	}
//	//メソッドを介して値を変える
//	void setScore(int score) {
//		if (score < 0 || score > 100) {
//			System.out.println("Invalid Score!");
//			return;
//		}
//		this.score = score;
//	}
//	//getter
//	int getScore() {
//		return this.score;
//	}
//	
//	//アクセスを制限する修飾子をつける
//	 String getResult() {//本当はprivate String getResultになる。
//		if (this.score >= 80) {
//			return "Pass";
//		} else {
//			return "Fail";
//		}
//	}
//}
//
//public class test01{
//	public static void main(String[] args) {
//		User user1 = new User("ami", 80, 27);
//		System.out.println(user1.getUserString());//インスタンス.～～
//		user1.setScore(90);//user1のスコアを更新する
//		System.out.println(user1.getUserString());
//		
//		User user2 = new User("takano", 100, 99 );
//		System.out.println(user2.getUserString());
//	}
//}
//package test01;//「test01のコードです」

//class User {	//①クラスを作る
//	String name;//名前②フィールド定義
//	private int score;//年齢②フィールド定義。privateでクラスの外からはアクセスできない。別でメソッド定義必要。
//	
//	User(String name, int score) {//コンストラクタ
//		this.name = name;
//		this.score = score;
//	}
//	
//	String getUserString() {//文字を返す処理　メソッド
//		//return this.name + "," + this.score;
//		return name + "," + score;
//	}
//	
//	//int getUserScore() {//数字を返す処理 メソッド
//		//return score;
//	//}
//	
//	void setScore(int Score) {//間違えた値ならInvalid score!と返す処理 メソッド
//		if (score < 0 || score > 100) {
//			System.out.println("Invalid score!");
//			return;
//		}
//	}
//	
//	private int getScore() {//private int scoreを呼び出すためのメソッド
//		return this.score;
//	}
//}//ここまでUserクラス設定

//public class test01 {//③メインのクラスはここですよという箱
//	public static void main(String[] args) {
//		User user1 = new User("Taro", 70);//④インスタンスができる
//		User user2 = new User("Jiro", 80);
//		user1.setScore(900);//メソッドを呼び出す処理
//		System.out.println(user1.getScore());
//	}
//}

//クラス継承について
package test01;

interface School {
	//interfaceは機能を束ねるものなので、絶対にOverrideでメソッドの詳細を書く必要あり
	void haveClass();//メソッド。「授業をする」という約束
	void angry();
}

class MathTeacher implements School {
	@Override
	public void haveClass() {
		System.out.println("数学の問題を解いています。");
	}
	@Override
	public void angry() {
		System.out.println("キレました");
	}
}

class MusicTeacher implements School {
	@Override
	public void haveClass() {
		System.out.println("音楽の練習をしています。");
	}
	@Override
	public void angry() {
		System.out.println("キレました");
	}
}




















