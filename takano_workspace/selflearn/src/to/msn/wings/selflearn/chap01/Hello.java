package to.msn.wings.selflearn.chap01;

import java.time.LocalDateTime;

public class Hello {

  public static void main(String[] args) {
    LocalDateTime time = LocalDateTime.now();
    System.out.println(time);
    
    
    
    //12,345円の消費税10%を足した金額を出力する
//    int price = 12345;
//    System.out.println((price * 0.1) + price);
    
    double tax = 1.1;
    int price = 12345;
    System.out.println(price * tax);
    
    //finalを使って定数を宣言し、出力する。
    final double TAX = 1.1;
    System.out.println(TAX);
    
    System.out.println("Taro said hi. \"Hi!\", he replied.");
    
    //配列に1から5までの数字を入れる
    int[] scores_array = {1,2,3,4,5}; 
    int[] int_array = {1,2,3,4,5};
    
    //配列に「あ～お」までの文字を入れる
    String[] char_array = {"あ","い","う","え","お"};
    var new_str_array = new String[] {"あ","い","う","え","お"};//これはnewで初期化をしている
    
    //* .lengthで配列の要素数を取得する
    System.out.println(char_array.length);
    System.out.println(scores_array.length);
    
    //多次元配列
    int[][] scores = {
    		{70,80,90},//scores[0]
    		{30,40,50},//scores[1]
    };
    System.out.println(scores[1][2]);
  }
}
