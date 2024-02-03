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

package java_work0202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TodoApp {

	public static void main(String[] args) {

		String operation = "1/登録, 2/重要度変更, 3/削除, 4/終了";//ユーザーが入力する操作の一覧

		List<String> todoApp = new ArrayList<>();

		System.out.println("Todoは1件もありません。");

		//操作が4にならない限りずっと「——操作を入力してください。——」を繰り返す
		while (true) {
			System.out.println("——操作を入力してください。——");
			System.out.println(operation);

			//ユーザーが入力する操作
			Scanner contentsNumber = new Scanner(System.in);
			int inputOperationNumber = contentsNumber.nextInt();

			//1/登録が押されたときの処理
			if (inputOperationNumber == 1) {
				System.out.println("新規Todoを作成します");
				System.out.println("Todo内容を入力してください");

				//Todo内容を入力させる
				Scanner contents = new Scanner(System.in);
				String inputContents = contents.nextLine();

				//重要度を入力させる
				System.out.println("重要度を1～10で入力してください");
				Scanner importance = new Scanner(System.in);
				int inputImportance = 0;

				try {//入力が1より小さいまたは10より大きかったら入力を継続
					inputImportance = importance.nextInt();
					if (inputImportance < 1 || inputImportance > 10) {
						System.out.println("重要度は1から10の間で入力してください");
						continue;
					}
				} catch (InputMismatchException e) {//入力が整数以外だったら入力を継続
					System.out.println("重要度は整数で入力してください");
					importance.next();
					continue;
				}

				//TodoAppに inputContentsNumberとinputImportanceを追加し続ける
				String contentsOfTodoApp = inputContents + "/重要度：" + inputImportance;

				todoApp.add(contentsOfTodoApp);

				System.out.println("1件追加しました");

				//重要度順にソートする
				Collections.sort(todoApp,
						Comparator.comparingInt(s -> Integer.parseInt(s.split("/")[1].replaceAll("[^0-9]", ""))));

				System.out.println("Todoリスト：");

				//拡張for文（またはfor-each文）は、コレクションや配列などの要素を順番に取り出すための簡潔で便利な方法
				//todoAppリストの各要素（String型）を順番にtodoという変数に代入し、ブロック内でそれぞれの要素に対して処理を行う
				for (String todo : todoApp) {
					System.out.println(todo);
				}
				//2/重要度変更が押されたときの処理
			} else if (inputOperationNumber == 2) {
				System.out.println("重要度を変更します。変更したい項目を入力してください。");
				System.out.println(todoApp);

				//変更したい項目を入力する
				Scanner changedContents = new Scanner(System.in);
				String inputchangedContents = changedContents.nextLine();

				//inputchangedImportanceの重要度を取得するS
				System.out.println("新しい重要度を入力してください。");
				Scanner changedImportance = new Scanner(System.in);
				int inputchangedImportance = changedImportance.nextInt();
				
				//変更したい項目が配列の項目と一致しているばあいに処理をおこなう
				for (int i = 0; i < todoApp.size(); i++) {
					String todo = todoApp.get(i);

					if (inputchangedContents.equals(todo)) {
						//inputchangedContentsの重要度を取得する
						int importanceOfinputchangedContents = Integer
								.parseInt(todo.split("/")[1].replaceAll("[^0-9]", ""));
						
						//取得したinputchangedContentsの重要度を入力したinputchangedImportanceで書き換える
						

						char charimportanceOfInputchangedContents = (char) importanceOfinputchangedContents;
						char charInputchangedImportance = (char) inputchangedImportance;
						//もし、inputchangedContentsの重要度がinputchangedImportanceの重要度より大きかったら
						//重要度を入れ替える
						if (importanceOfinputchangedContents > inputchangedImportance) {

							todoApp.set(i, todo.replace(charimportanceOfInputchangedContents,
									charInputchangedImportance));
						} else {
						}
					}

				}
				//重要度順にソートする
				Collections.sort(todoApp,
						Comparator.comparingInt(s -> Integer.parseInt(s.split("/")[1].replaceAll("[^0-9]", ""))));

				System.out.println("Todoリスト：");
				
				for (String todo : todoApp) {
                    System.out.println(todo);
                }
			}

		}

	}

}


	}

}
