package java_practice;

import java.util.Scanner;

class Onigiri {
	int calories;//メンバ変数：それぞれの栄養成分を表す変数として宣言
	double protein;
	double fat;
	double carbo;
	double fiber;

	//コンストラクタ：各食材の栄養成分を初期化
	Onigiri(int calories, double protein, double fat, double carbo, double fiber) {
		this.calories = calories;
		this.protein = protein;
		this.fat = fat;
		this.carbo = carbo;
		this.fiber = fiber;
	}

	//各栄養成分を取得するためのメソッド：値を文字列として返すように宣言
	String getOnigiriCalories() {
		return this.calories + "kcal";
	}

	String getOnigiriProtein() {
		return this.protein + "g";
	}

	String getOnigiriFat() {
		return this.fat + "g";
	}

	String getOnigiriCarbo() {
		return this.carbo + "g";
	}

	String getOnigirifiber() {
		return this.fiber + "g";
	}
}

class Syokupan {
	int calories;
	double protein;
    double fat;
    double carbo;
    double fiber;
    Syokupan(int calories, double protein, double fat, double carbo, double fiber) {
    	this.calories = calories;
    	this.protein = protein;
    	this.fat = fat;
    	this.carbo = carbo;
    	this.fiber = fiber;
    }
    String getSyokupanCalories() {
    	return this.calories + "kcal";
    }
    String getSyokupanProtein() {
    	return this.protein + "g";
    }
    String getSyokupanFat() {
    	return this.fat + "g";
    }
    String getSyokupanCarbo() {
    	return this.carbo + "g";
    }
    String getSyokupanfiber() {
    	return this.fiber + "g";
    }
}

class IngredientsSum { 
	//カロリーを合計するメソッド
	static int calculateCaloriesSum(Onigiri onigiri, Syokupan syokupan) {
		return onigiri.calories + syokupan.calories;
	}
	//タンパク質を合計するメソッド
	static double calculateProteinSum(Onigiri onigiri, Syokupan syokupan) {
		return onigiri.protein + syokupan.protein; 
	}
	//脂質を合計するメソッド
	static double caculateFatSum(Onigiri onigiri, Syokupan syokupan) {
		return onigiri.fat + syokupan.fat;
	}
	//炭水化物を合計するメソッド
	static double calculateCarboSum(Onigiri onigiri, Syokupan syokupan) {
		return onigiri.carbo + syokupan.carbo;	
	}
	//食物繊維を合計するメソッド
	static double calculateFiberSum(Onigiri onigiri, Syokupan syokupan) {
		return onigiri.fiber + syokupan.fiber;
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("食材を入力してください（onigiri/syokupan）");
		String inputFood = scanner.next();
		
		Onigiri onigiri = new Onigiri(204, 3.0, 0.4, 45.0, 0.5);
        Syokupan syokupan = new Syokupan(150, 5.0, 2.5, 28.0, 2.5);
        
        int caloriesSum = calculateCaloriesSum(onigiri, syokupan);
        double proteinSum = calculateProteinSum(onigiri, syokupan);
        double fatSum = caculateFatSum(onigiri, syokupan);
        double carboSum = calculateCarboSum(onigiri, syokupan);
        double fiberSum = calculateFiberSum(onigiri, syokupan);
       
       class IngredientsAlert {
        	//合計カロリーを受け取ってアラートするメソッド
        	void displayCaloriesAlert(int caloriesSum) {
        		if (caloriesSum < 2000) {
        			System.out.println("カロリー不足です");
        		} else {
        			System.out.println("カロリーは十分です");
        		}
        	}
        	//合計タンパク質を受け取ってアラートするメソッド
        	void displayProteinAlert(double proteinSum) {
        		if (proteinSum < 65) {
        			System.out.println("タンパク質不足です");
        		} else {
        			System.out.println("タンパク質は十分です");
        		}
        	}
        	//合計脂質を受け取ってアラートするメソッド
        	void displayFatAlert(double fatSum) {
        		if (fatSum < 56) {
        			System.out.println("脂質不足です");
        		} else {
        			System.out.println("脂質は十分です");
        		}
        	}
        	//合計炭水化物を受け取ってアラートするメソッド
        	void displayCarboAlert(double carboSum) {
        		if (carboSum < 30) {
        			System.out.println("炭水化物不足です");
        		} else {
        			System.out.println("炭水化物は十分です");
        		}
        	}
        	//合計食物繊維を受け取ってアラートするメソッド
        	void displayFiberAlert(double fiberSum) {
        		if (fiberSum < 1) {
        			System.out.println("食物繊維不足です");
        		} else {
        			System.out.println("食物繊維は十分です");
        		}
        	}
        }
        
        //IngredientsAlertをインスタンス化（＝具体的なモノとしてIngredientsAlertを作成）
        //して、アラートを表示
          IngredientsAlert ingredientsAlert = new IngredientsAlert();
          
          //入力された食材によってアラートを表示
          if ("onigiri".equals(inputFood)) {
        	  ingredientsAlert.displayCaloriesAlert(caloriesSum);
        	  ingredientsAlert.displayProteinAlert(proteinSum);
        	  ingredientsAlert.displayFatAlert(fatSum);
        	  ingredientsAlert.displayCarboAlert(carboSum);
        	  ingredientsAlert.displayFiberAlert(fiberSum);
          } else if ("syokupan".equals(inputFood)) {
        	  ingredientsAlert.displayCaloriesAlert(caloriesSum);
        	  ingredientsAlert.displayProteinAlert(proteinSum);
        	  ingredientsAlert.displayFatAlert(fatSum);
        	  ingredientsAlert.displayCarboAlert(carboSum);
        	  ingredientsAlert.displayFiberAlert(fiberSum);
          } else {
        	  System.out.println("対応する食材がありません");
          }
          scanner.close();
	}
}

	
	