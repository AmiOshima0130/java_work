//Todoは1件もありません。
//——操作を入力してください。——
//1/登録 2/重要度変更 3/削除 4/終了 >1
//新規Todoを作成します。
//Todo内容を入力してください>ミルクを買う
//重要度を1~10(最大)で入力してください >３
//1件追加しました。
//0・・・ミルクを買う/重要度:3

//——操作を入力してください。——
//1/登録 2/重要度変更 3/削除 4/終了 >1
//新規Todoを作成します。
//Todo内容を入力してください>銀行へ行く (預入)
//重要度を1~10(最大)で入力してください >10
//1件追加しました。
//0・・・銀行へ行く (預入)/重要度:10
//1・・・ミルクを買う/重要度:3

//——操作を入力してください。——
//1/登録 2/重要度変更 3/削除 4/終了 >2
//重要度を変更します。番号を入力してください。0~2 >2
//重要度を再設定してください。 >7
//重要度を変更しました。
//0・・・銀行へ行く (預入)/重要度:10
//1・・・ミルクを買う/重要度:7
//2・・・キャットフードを買う/重要度:5

//——操作を入力してください。——
//1/登録 2/重要度変更 3/削除 4/終了 >3
//Todoを削除します。番号を入力してください。0~2 >2
//1件削除しました。
//0・・・銀行へ行く (預入)/重要度:10
//1・・・ミルクを買う/重要度:7
//——操作を入力してください。——
//1/登録 2/重要度変更 3/削除 4/終了 >4
//アプリケーションを終了します。
//
//
//1.「Todoは1件もありません。」を表示する
//2.「——操作を入力してください。——」を表示する
//3.「1/登録 2/重要度変更 3/削除 4/終了」を表示する
//
//4が押されるまで処理を繰り返す
//Todoリストの一覧はArrayListで管理する
//
//必要なもの
//ユーザーが入力する操作・Todo内容・重要度
//
//1が押されたときは「新規Todoを作成します」を表示する
//「Todo内容を入力してください」を表示する
//ユーザーに入力させる
//「重要度を1~10(最大)で入力してください」を表示する
//「1件追加しました」を表示する
//現在入力されているTodoを0番目から順に「ArrayListの位置・・・Todo名/重要度：」として表示する
//
//2が押されたときは「重要度を変更します。番号を入力してください。現在登録されているTodoを、重要度順に0番目から番号を表示する」
//「重要度を再設定してください。」と表示。
//ユーザーにTodoの何番目を変更するか入力させる。
//押された番号の優先順位を変更する。
//「重要度を変更しました」と表示する。
//重要度順に、現在登録されているTodoを一覧表示する。
//
//3が押されたときは「Todoを削除します。番号を入力してください。現在登録されているTodoを、重要度順に0番目から番号を表示する」
//ユーザーにTodoの何番目を削除するか入力させる。
//「○件削除しました」と表示する。
//重要度順に、現在登録されているTodoを一覧表示する。
//
//4が押されたときは「アプリケーションを終了します」と表示する。
//アプリケーションを終了する。

package todoapp;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {

	public static void main(String[] args) {

		//ユーザーからの入力が必要になるのでScannerインスタンス
		Scanner sc = new Scanner(System.in);

		//メニューの表示->選択->何かしら処理が繰り返されている。
		//何度繰り返されるかわからないのでwhileを使って繰り返す。

		//todoが追加されたときに項目を格納する変数をArrayListで定義
		ArrayList<Todo> list = new ArrayList<>();

		System.out.println("****TodoApp****");
		System.out.println("Todoは1件もありません。");
		
		int select = 0;
		
		while (true) {
			//まずは「4/終了」が押されたときの処理を書く
			System.out.println("——操作を入力してください。——");
			System.out.println("1/登録 2/重要度変更 3/削除 4/終了>");
			select = sc.nextInt();
			sc.nextLine();
			
			if (select == 4) {
				System.out.println("アプリケーションを終了します。");
				return;
			}
			//「1/登録」を選んだ時の処理
			else if (select == 1) {

				//listの要素がゼロだった時
				if (list.size() == 0) {
					System.out.println("新規Todoを作成します。");
					System.out.println("Todo内容を入力してください。>");
					String contents = sc.nextLine();

					System.out.println("重要度を1~10(最大)で入力してください。>");
					int importance = sc.nextInt();

					//Todo内容と重要度を受け取り、todoインスタンスを生成し、listに追加する。
					Todo todo = new Todo(contents, importance);
					list.add(todo);

					System.out.println("1件追加しました。");

					//ArrayListの要素をフォーマットして表示する「ex.0・・・ミルクを買う/重要度:3」
					for(int i=0; i<list.size(); i++) {
						System.out.println(String.format("%d・・・%s%n", i, list.get(i).showResult()));
					}
				} 
				//listの要素が1以上だった時
				else if(list.size() >= 1){
					System.out.println("新規Todoを作成します。");
					System.out.println("Todo内容を入力してください。>");
					String contents = sc.nextLine();
					
					System.out.println("重要度を1~10(最大)で入力してください。>");
					int importance = sc.nextInt();
					
					//Todo内容と重要度を受け取り、todoインスタンスを生成し、listに追加する。
					Todo todo = new Todo(contents, importance);
					list.add(todo);
					
					System.out.println("1件追加しました。");
					
					//ArrayListの要素をフォーマットして表示する「ex.0・・・ミルクを買う/重要度:3」
					for(int i=0; i<list.size(); i++) {
						System.out.println(String.format("%d・・・%s%n", i, list.get(i).showResult()));
					}
					
					//重要度ごとにソートを呼び出す
					sortTodo(list);
				}
			//2/重要度変更を選んだ時の処理
			} else if(select == 2) {
				System.out.println("重要度を再設定してください。>");
				int no = sc.nextInt();
				sc.nextLine();//改行コードをクリア
				int newImportance = sc.nextInt();
				sc.nextLine();
				list.get(no).changeImportance();
				
				System.out.println("重要度が変更されました");
				sortTodo(list);
			}
		}

	}
	//ソートするメソッド
	public static void sortTodo(ArrayList<Todo> list) {
		for(int i = 0; i < list.size() -1; i++) {
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(i).importance < list.get(j).importance) {
					Todo temporary = list.get(i);//一時的に保存
					//i 番目の要素に j 番目の要素の値をセットします。この時点で i 番目の要素の値が変わります。
					list.set(i, list.get(j));
					//j 番目の要素に temp の値をセットします。ここで temp に保存されていた元の i 番目の要素の値が j 番目の要素に移動します。
					list.set(i, temporary);
					
				}
			}
		}
	}
}


//todoクラス
class Todo {
	//フィールド
	String contents;//内容
	int importance;//重要度
	
	//コンストラクタは、newキーワードを使用してオブジェクトを生成する際に呼び出されます
	//今回は(名前、種類)を指定してインスタンスを生成できるようにする
	
	public Todo(String contents, int importance) {
		this.contents = contents;
		this.importance = importance;
	}
	
	//自分自身の情報を文字列として表示させるメソッド「ex.ミルクを買う/重要度:3」
	public String showResult() {
		return String.format("%s / 重要度 : %d", contents, importance);
	}
	
	//重要度は自分のフィールドだけど、操作されるので、インスタンスメソッドとして作る
	//「2/重要度変更」で重要度が変更されたときの処理
	public void changeImportance(int i, int no) {
		
		
		
		
	}
}
