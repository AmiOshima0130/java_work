//あなたは自分のウェブサイトでプレゼント企画を実施しました。
//プレゼントには A と B の二種類があります。

//当選者は以下の条件に従って、選出されます。

//・整数 X の倍数番目の応募者はプレゼント A の当選者とする
//・整数 Y の倍数番目の応募者はプレゼント B の当選者とする

//応募者の数が与えられるので、各応募者のプレゼント当選情報を出力してください。
//プレゼント A と B の両方当選した人は AB、A だけ当選した人は A、B だけ当選した人は B、
//どちらも当選してない人は N を出力してください。

//入力例 1 の場合、応募者の人数は 5 人なので、5 人の当選情報を出力します。
//プレゼント A の当選者は、2 の倍数番目の応募者で、プレゼント B の当選者は 4 の倍数の当選者なので、
//2 番目の応募者は A、4 番目の応募者は AB となり、それ以外の応募者は N になります。


//N（人数）の数を入力する
//X(Aの当選者)の数を入力する
//Y(Bの当選者)の数を入力する
//Nの数を出力する
//Nは入力された値をそのまま返す
//XはAを出力する
//XはN以下の時、N*Xの数のときにAを出力する
//YはBを出力する
//YはN以下の時、N*YのときにBを出力する
//XかつYのとき、ABを出力する

package paiza_practice_c097;

import java.util.Scanner;

public class C097 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//応募者人数
		int N = scanner.nextInt();
		//Aの当選者
		int X= scanner.nextInt();
		//Bの当選者
		int Y = scanner.nextInt();
		
		for (int i=1; i<=N; i++){
			if(i % X == 0 && i % Y == 0) {
				System.out.println("AB");
			} else if(i % X == 0) {
				System.out.println("A");
			} else if (i % Y == 0) {
				System.out.println("B");
			} else {
				System.out.println("N");
			}
		}
		scanner.close();
	}
}
