import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bonus2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		//輸入班級人數
		System.out.print("請輸入班級人數 : ");
		int input = scanner.nextInt();
		
		//學生人數必須在1~20之間
		if(input >= 1 && input <= 20)
		{
			//輸入學生成績並轉成陣列
			System.out.print("開始輸入學生成績 每一個數字用空白隔開 : ");
			String score = sc.nextLine();
			String[] scoreArray = score.split(" ");
			
			//檢查學生成績是否合法
			if(scoreArray.length == input) {
				//如果陣列的長度跟當初設定的班級人數不同的話就停止程式
				if(checkScore(changeArrayToList(scoreArray))) {
					//列印所有成績
					printScore(changeArrayToList(scoreArray));
					//找到不及格中最高分
					checkFailed(changeArrayToList(scoreArray));
					//找到及格中的最低分
					checkPass(changeArrayToList(scoreArray));
				}else {
					System.out.print("學生成績為0~100分\n\n====== 結束程式 ======");
				}
			}else {
				System.out.print("學生成績輸入次數有誤\n\n====== 結束程式 ======");
			}

		}else {
			System.out.print("學生人數為1~20人\n\n====== 結束程式 ======");
		}
		

		
	}
	
	//找到及格中最低分
	public static void checkPass(ArrayList<Integer> intScoreArray) {
		Integer removeIndex = 0;
		//由大到小排序
		Collections.sort(intScoreArray);
		
		//確認最大的數字是否大於60 如果沒有代表班上沒人及格
		if(intScoreArray.get(intScoreArray.size()-1) >= 60) {
			//因為排序過了 找到符合條件最後一個index就可以了
			for(int i=0; i<intScoreArray.size(); i++) {
				if(intScoreArray.get(i) < 60) {
					removeIndex = i+1;
				}
			}
			//利用前面的index把list內容刪除
			if(removeIndex != 0) {
				for(int i=0; i<removeIndex; i++) {
					intScoreArray.remove(0);
				}
			}
			//及格分數最低
			System.out.println(intScoreArray.get(0));
		}else {
			//沒人及格
			System.out.println("worst case");
		}
	}
	//找到不及格中最高分
	public static void checkFailed(ArrayList<Integer> intScoreArray) {
		Integer removeIndex = 0;
		//由小到大排序
		Collections.sort(intScoreArray,Collections.reverseOrder());
		//確認最小的數字是否小於60 如果大於60 代表全部人都及格
		if(intScoreArray.get(intScoreArray.size()-1) < 60) {
			//因為排序過了 找到符合條件最後一個index就可以了
			for(int i=0; i<intScoreArray.size(); i++) {
				if(intScoreArray.get(i) >= 60) {
					removeIndex = i+1;
				}
			}
			//利用前面的index把list內容刪除
			if(removeIndex != 0) {
				for(int i=0; i<removeIndex; i++) {
					intScoreArray.remove(0);
				}
			}
			//不及格最高分
			System.out.println(intScoreArray.get(0));
		}else {
			//全部人及格
			System.out.println("best case");
		}
	}

	//將陣列轉換成List
	public static ArrayList<Integer> changeArrayToList(String[] strScoreArray) {
		//建立數字型態的list
		ArrayList<Integer> intScoreArray = new ArrayList();
		
		//將字串陣列變成數字的list
		for(int i=0; i<strScoreArray.length; i++) {
			intScoreArray.add(Integer.valueOf(strScoreArray[i]));
		}
		//回傳List屬性的成績
		return intScoreArray;
	}
	
	//將所有成績有低到高排序
	public static void printScore(ArrayList<Integer> intScoreArray) {
		//把List內的資料由小到大排序
		Collections.sort(intScoreArray);
		//將List內的資料一筆一筆抓出來並判斷是否為最後一個字，若不是最後一個字就加一個空格
		for(int i=0; i<intScoreArray.size(); i++) {
			System.out.print(intScoreArray.get(i));
			//-1的用意是因為i是從0開始算但是Size是從1開始
			if(i == intScoreArray.size()-1) {
				System.out.println();
			}else {
				System.out.print(" ");
			}
		}		
	}
	
	//確認分數是否落在合法範圍
	public static boolean checkScore(ArrayList<Integer> intScoreArray) {
		for(int i=0;i<intScoreArray.size();i++) {
			if(intScoreArray.get(i) < 0 || intScoreArray.get(i) > 100) {
				return false;
			}
		}
		return true;
	}
}
