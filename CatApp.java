package java_work0202;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CatApp {

	public static void main(String[] args) {
		//今回で言えば、猫の種類はランダムに決める必要があるのでRandomインスタンス
		//ユーザーからの入力を受け取るのでScannerインスタンスが必要となる
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		//続いて定数を定義していこう。
		//今回[白,黒,茶トラ]という猫の種類は配列で扱っておくと便利そうだ。
		//Catインスタンスを格納するArrayListもこのタイミングで用意しておこう。
		//今回は猫を何匹でも集められる仕様なので、
		//この場合は要素数が決まっている配列よりもArrayListの方が便利だ
		final String[] TYPES = {"白", "黒", "茶トラ"};
		ArrayList<Cat> list = new ArrayList<>();
		
		//実行例を見ると、
		//メニューの表示->選択->何かしら処理
		//というのが繰り返されているのがわかる。なのでforかwhileを使うことになる。
		//繰り返す回数がわかる場合はforそうでない場合はwhileを使うというのが基本だ。
		//今回は何度繰り返されるかわからない、なのでwhile文を使っていこう。
		System.out.println("***猫集め***");
		//まずは、終了が選ばれたときの処理を記述
		//このように特殊な場合にすぐにreturnして処理を抜けるというのは早期リターンと呼ばれていて、
		//処理のネストが深くならない上、
		//わかりやすいという特徴があるのでおすすめだ
		while(true) {
			System.out.print("1.集める 2.遊ぶ 3.終了>>");
			int select = sc.nextInt();
			if(select == 3) {
				System.out.println("***結果***");
				for(Cat c : list) {
					System.out.println(c.showStatus());
				}
				System.out.println("また遊んでね。おしまい");
		        return;
			}
			//分岐の骨組みを先に書いてしまうのもよく行う手法だ。
			//今回、if~elseで組んでも同じだが、
			//1を選んだのか2を選んだのかがわかりやすいいように上記のif ~ else if文を使った。
			if(select == 1) {
				//猫の種類の配列から一つを取り出している。
				//ほぼイディオムとも言ってよい処理なので問題はないだろう。
				String type = TYPES[rand.nextInt(TYPES.length)];
				//%sは後に指定される引数（typeと思われる）で置き換えられます。
				//変数 type の値に基づいてフォーマットされたメッセージを表示する
				System.out.printf("%s猫を見つけた！%n",  type);
				System.out.print("この猫に名前をつけてください>>");
				
				//名前を受け取りCatインスタンスを生成し、リストに追加する
				String name = sc.next();
				Cat cat = new Cat(name, type);
				list.add(cat);
				System.out.println(cat.name + "が仲間に加わった！");
			} 
			//ここでもまずは異常系の処理を書いていこう。
			//このように最初に異常系の処理を書いて抜けるようにするとネストが浅くなる。
			//ここではreturnではなくcontinueだ。
			else if(select == 2) {
				if(list.size() == 0) {
					System.out.println("まだ遊ぶ猫がいません。。。");
					continue;
				}
				//showStatus()の結果をフォーマットして表示します
				for(int i = 0; i < list.size(); i++) {
					System.out.printf("%d・・・%s%n", i, list.get(i).showStatus());
				}
				//リストに入っている猫をgetで取り出して、
				//そのインスタンスがplayメソッドを実行することで親密度があがるのであった。
				 System.out.print("どの猫と遊びますか?>>");
				 int no = sc.nextInt();
				 list.get(no).play();
				 //sortCatのよびだし
				 sortCat(list);
			}
		}
	}
	//今回は親密度で並び替えを行わなくてはならない。
	//なので親密度が変わったまさにこのあとにlistのソート処理をいれる。
	//ただ、この下に書くと2を選んだときの記述が長くなりすぎるので、
	//この部分は以下のようにメソッドにしよう。以下の処理をメインメソッドの外に書く。
	//このコードは、ArrayList内のCatオブジェクトを
	//intimacy（親密度）の降順にソートするための静的メソッドです。
	
	static void sortCat(ArrayList<Cat> list) {
		for(int i = 0; i < list.size()-1; i++) {
			for(int j = i+1; j < list.size(); j++) {
				//list.get(i).intimacy < list.get(j).intimacyがtrueであれば、
				//i番目の要素のintimacyがj番目の要素のintimacyよりも小さいということです。
				//この場合、要素を入れ替えます。
				if(list.get(i).intimacy < list.get(j).intimacy) {
					//tempを使ってi番目の要素を退避し、j番目の要素をi番目にセットし、
					//最後にtempの値をj番目にセットしています。
					Cat temp = list.get(i);
					list.set(i, list.get(j));
					list.set(i,  temp);
				}
			}
		}
	}
}

class Cat {
	//フィールド
	String name;
	private String type;
	int intimacy = 0;
	
	//コンストラクタ
	//クラスのインスタンスを生成するための特別なメソッドです。
	//コンストラクタはクラス名と同じ名前を持ち、戻り値の型が指定されていません。
	//主な目的は、新しいオブジェクトを初期化することです。
	//コンストラクタは、newキーワードを使用してオブジェクトを生成する際に呼び出されます
	//今回は(名前、種類)を指定してインスタンスを生成できるようにする
	public Cat(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	//自分自身の情報を文字列情報として表せるメソッドex.やま[茶トラ](0)
	//%s:文字列、%d:整数。%f:少数、%n:改行
	//String.gormat("フォーマット文字列", 仮置きした値);
	public String showStatus() {
	    return String.format("%s[%s](%d)", this.name, this.type, this.intimacy);
	}

	
	//メソッドをどこに記述するかを考える際、重要となるのが自分のフィールド(パラメータ)を操作する部分があったら
	//それはインスタンスメソッドとして作成するということ
	//今回は遊ぶことによって親密度があがるのでこの部分はインスタンスメソッドとして記述していく
	public void play() {
		System.out.println(this.name + "と遊んだ");
		System.out.println("...");
	    System.out.println(this.name+"の親密度がアップした!");
	    this.intimacy++;
	} 
}

