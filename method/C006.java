package c006;

import java.util.ArrayList;
import java.util.Scanner;

public class C006 {
	//メインで実行させるクラス
	public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			//パラメーターを定義・入力させる
			int parameter = sc.nextInt();
			//ユーザーの人数を入力させる
			int users = sc.nextInt();
			//トップ○を入力させる
			int top = sc.nextInt();
			
			int points[] = new int[parameter];//pointを配列に入れる
			
			//アイテムの種別ごとの得点・ユーザーごとのアイテム持ち数を入力させる
			for(int i = 0; i < parameter; i++) {
				int point = sc.nextInt();
				points[i] = point; // 入力された値をpoints配列に格納
				
				//入力したpointsをArrayListに入れる
				ArrayList<Integer> pointsArray  = new ArrayList<Integer>();
				for(int j = 0; j < users; j++) {
					int items = sc.nextInt();
				}
				
			}
	}

	//ユーザーのスコアを計算するメソッド
	public int Calculate(int points, int items) {
		
	}
}
