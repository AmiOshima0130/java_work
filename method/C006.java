package java_work0202;

import java.util.Scanner;

public class C006 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//パラメーター入力
		int M = sc.nextInt();//ユーザーの人数入力
		int K = sc.nextInt();//トップK入力
		
		Ranking ranking = new Ranking(N);
		//アイテム種別毎の得点入力・ユーザーのアイテム持つ数入力
		ranking.inputPoint();
		ranking.showResult();

	}
	
	

}

class Ranking {
	//フィールド
	int N;//パラメーター
	
	public Ranking(int N) {
		this.N = N;
		
	}
	
	
	//アイテム種別毎の得点入力メソッド
		public void inputPoint() {
			Scanner sc = new Scanner(System.in);
			for(int i = 0; i < N; i++) {
				int C = sc.nextInt();//アイテム種別毎の得点
				int X = sc.nextInt();//ユーザーのアイテム持つ数
			}
		}
		
	//結果を表示するメソッド
		public void showResult() {
	        // 結果を表示する処理を書く
	    }
}