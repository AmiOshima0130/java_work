// キーがString型、値がInteger型のHashMapを作成
//HashMap<String, Integer> myHashMap = new HashMap<>();
//
//要素の追加
//myHashMap.put("Key1", 100);
//myHashMap.put("Key2", 200);
//
//要素の取得
//int value = myHashMap.get("Key1"); // キー"Key1"に対応する値を取得
//
//要素の変更
//myHashMap.put("Key1", 150); // キー"Key1"に対応する値を変更
//
//要素の削除
//myHashMap.remove("Key1"); // キー"Key1"に対応する要素を削除
//
//存在チェック
//boolean containsKey = myHashMap.containsKey("Key1"); // キー"Key1"が存在するか確認
//boolean containsValue = myHashMap.containsValue(150); // 値150が存在するか確認



package java_work0202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C043 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // プレイヤーIDの数を入力
        int n = scanner.nextInt();

        // プレイヤーIDをリストに格納
        List<Integer> playerIDs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            playerIDs.add(id);
        }

        // プレイヤーIDの出現回数を数える
        //プレイヤーIDとその出現回数を格納するためのマップです。
        //countMapという変数を宣言し、その型をHashMap<Integer, Integer>に指定しています
        Map<Integer, Integer> countMap = new HashMap<>();
        //: 拡張forループを使用して、playerIDsリスト内の各プレイヤーIDに対して繰り返します。
        for (int id : playerIDs) {
        //マップにプレイヤーIDをキーとして登録
        //countMap.getOrDefault(id, 0)は、既にマップにそのキーが存在する場合はその値を取得し、
        //存在しない場合はデフォルト値として0を使用します
        //それに1を加えて、新しい値として再度マップに登録します。
        //つまり、各プレイヤーIDの出現回数をカウントしていることになります。
            countMap.put(id, countMap.getOrDefault(id, 0) + 1);
        }

        // 最頻値のリスト
        //型をArrayList<Integer>に指定しています。これは、最頻値を格納するためのリストです。
        List<Integer> mostFrequentIDs = new ArrayList<>();

        // 最も頻繁に出現する数を見つける
        //最大の出現回数を格納する変数 maxCount を初期化
        int maxCount = 0;
        //拡張forループを使用して、countMap内の各エントリに対して繰り返します。
        //各エントリはプレイヤーIDとその出現回数です。
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {//もし現在のエントリの出現回数が maxCount よりも大きければ、以下の処理を実行
                maxCount = entry.getValue();//maxCount を現在のエントリの出現回数に更新します。
                mostFrequentIDs.clear(); // リストをクリア
                mostFrequentIDs.add(entry.getKey());//最頻値リストに現在のプレイヤーIDを追加
            } 
             else if (entry.getValue() == maxCount) {//もし現在のエントリの出現回数が maxCount と等しい場合は、最頻値リストに追加
                mostFrequentIDs.add(entry.getKey());//最頻値リストに現在のプレイヤーIDを追加
            }
        }

        // 結果を出力
        Collections.sort(mostFrequentIDs);//最頻値リストを昇順にソートします
        //最頻値リスト内の各プレイヤーIDを表示します。各IDの後にスペースが挿入されます。
        for (int id : mostFrequentIDs) {
            System.out.print(id + " ");
        }
    }
}
