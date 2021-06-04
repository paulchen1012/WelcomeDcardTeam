import java.util.Scanner;

public class Bonus1 {
	public static void main(String[] args) {

		//AND OR XOR為計算邏輯閘後的回傳值
		String AND,OR,XOR;
		//A B C分別代表輸入的數字
		String A = null, B = null, C = null;
		//判斷輸入字元是否有誤
		boolean success = true;
		Scanner scanner = new Scanner(System.in);
		
		//主要判斷輸入是否為數字
		try {
			
			System.out.print("請輸入a b c 三個正整數，並用空白隔開 : ");
			//使用者輸入
			String input = scanner.nextLine();
			//將使用者輸入的字串用空白分開 並存成陣列
			String inputArray [] = input.split(" ");
			A = inputArray[0];
			B = inputArray[1];
			C = inputArray[2];

			//判斷A B C是否在合法的區間
			if(Integer.valueOf(A)>=10000 || Integer.valueOf(A) < 0) {
				System.out.print("A的數字區間為 0~9999\n\n====== 結束程式 ======");
				success = false;
			}
			if(Integer.valueOf(B)>=10000 || Integer.valueOf(B) < 0) {
				System.out.print("B的數字區間為 0~9999\n\n====== 結束程式 ======");
				success = false;
			}
			if(Integer.valueOf(C).equals("0") || Integer.valueOf(C).equals("1")) {
				System.out.print("C僅能輸入 0 或 1\n\n====== 結束程式 ======");
				success = false;
			}
		}catch(Exception e) {
			//若A B C無法轉換成數字 顯示輸入有誤
			System.out.print("輸入有誤\n\n====== 結束程式 ======");
			success = false;
		}
		
		//如果輸入正確即可開始計算
		if (success == true) {
			AND = typeAnd(A,B);
			OR = typeOr(A,B);
			XOR = typeXor(A,B);
			printType(AND,OR,XOR,C);
		}
	}
	
	//使用AND邏輯計算
	public static String typeAnd(String A, String B) {
		if(A.equals("0") == false && B.equals("0") == false) {
			return "1";
		}else {
			return "0";
		}
	}
	
	//使用OR邏輯計算
	public static String typeOr(String A, String B) {
		if(A.equals("0") == false || B.equals("0") == false) {
			return "1";
		}else {
			return "0";
		}
	}
	//使用XOR邏輯計算
	public static String typeXor(String A, String B) {
		if(A.equals("0") && B.equals("0") == false || A.equals("0") == false && B.equals("0")) {
			return "1";
		}else {
			return "0";
		}
	}
	
	//將結果符合邏輯的顯示出來
	public static void printType(String AND,String OR,String XOR,String C) {
		boolean impossible = false;
		if(AND.equals(C)) {
			System.out.println("AND");
			impossible = true;
		}
		if(OR.equals(C)) {
			System.out.println("OR");
			impossible = true;
		}
		if(XOR.equals(C)) {
			System.out.println("XOR");
			impossible = true;
		}
		if(impossible == false) {
			System.out.println("IMPOSSIBLE");
		}


	}
		
}
