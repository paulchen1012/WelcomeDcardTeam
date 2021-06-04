import java.util.Scanner;


public class Main{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//檢核輸入是不是輸入英文字母用的
		String [] english = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		String [] ENGLISH = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String ID;
		boolean key = false;
		
		while(key == false) {
			System.out.print("請輸入身分證字號 : ");
			ID = s.nextLine();
			//檢查三種狀況是否都是正確的分別是  檢查長度  檢查字首  檢查身分證字號是否有效
			if(checkIdLength(ID) && checkIdEnglish(ID,english,ENGLISH) && checkIdEffective(ID,english,ENGLISH)) {
				System.out.println("身分證正確");
				key = true;
			}
		}
		
	}
	//檢查輸入長度
	public static boolean checkIdLength(String ID){
		if(ID.length() != 10) {
			System.out.println("身分證長度有誤");
			return false;
		}else {
			return true;
		}
		
	}
	//檢查字首是否為英文
	public static Boolean checkIdEnglish(String ID, String[] english, String[] ENGLISH){
		for(int i=0; i<english.length;i++) {
			if(String.valueOf(ID.charAt(0)).equals(english[i])){
				return true;
			}
			if(String.valueOf(ID.charAt(0)).equals(ENGLISH[i])){
				return true;
			}
		}
		System.out.println("身分證字首有誤");
		return false;
	}
	//檢查身分證字號是否有效
	public static Boolean checkIdEffective(String ID, String[] english, String[] ENGLISH) {
		//idNum是對應英文字母的數字
		String [] idNum = {"10","11","12","13","14","15","16","17","34","18","19","20","21","22","35","23","24","25","26","27","28","29","32","30","31","33"};
		int [] Num = new int[11];
		int index = 0;
		//allNum是最後加總計算是否有效用的
		int allNum = 0;

		//先抓到字首英文字母對應的數字
		for(int i=0; i<english.length; i++) {
			if(String.valueOf(ID.charAt(0)).equals(english[i])){
				index = i;
				break;
			}
			if(String.valueOf(ID.charAt(0)).equals(ENGLISH[i])){
				index = i;
				break;
			}
		}
		//將英文字母對應的數字寫入
		Num[0] = Integer.valueOf(String.valueOf(idNum[index].charAt(0)));
		Num[1] = Integer.valueOf(String.valueOf(idNum[index].charAt(1)));
		
		//把除了英文字母以外的數字寫入
		for(int i=2; i<ID.length()+1; i++) {
			Num[i] = Integer.valueOf(String.valueOf(ID.charAt(i-1)));
		}
		//把有規則的部分先加總 以利後續計算
		for(int i=1; i<10; i++) {
			allNum += Num[i] * (10-i);
		}
		//再把沒有規則的部分加入
		allNum += (Num[0]*1) + (Num[10]*1);
		
		//規則為 對應身分證字號的所有數字相加除以10要整除
		if(allNum % 10 == 0) {
			return true;
		}else {
			System.out.println("此身分證字號為無效之號碼");
			return false;
		}
	}
}

