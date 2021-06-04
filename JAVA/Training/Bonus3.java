import java.util.Scanner;

public class Bonus3 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		//輸入本來一共有幾瓶可樂
		System.out.print("你有幾瓶可樂(1~200) : ");
		int colaNum = scanner.nextInt();
		
		//檢查輸入是否正確
		if(colaNum<1 || colaNum>200) {
			System.out.print("只能有1~200瓶的可樂\n\n====== 結束程式 ======");
		}else {
			//沒有跟朋友借空瓶
			int iDontCareFriend = doDrink(colaNum,0);
			//跟朋友借了空瓶 (( 任何情況下都有辦法還空瓶給朋友 所以理論上我覺得方法一根本不需要
			int haveFriend = doDrink(colaNum,1);
			
			//如果跟朋友借空瓶可以喝到比較多可樂的話就顯示比較多的情況((任何情況下都是 有借瓶子>=沒借瓶子
			if( haveFriend > iDontCareFriend) {
				//印出借了空瓶的計算結果
				System.out.println(haveFriend);
			}else {
				//印出沒借空瓶的計算結果
				System.out.println(iDontCareFriend);
			}
		}
	}
	
	//開始計算喝可樂
	public static int doDrink(int colaFullCount,int colaNotFullCount) {
		int colaAll = 0;			//總可樂數(滿的+空的)
		boolean isContinue = true;	//是否繼續除
		int drinkCount = 0;			//總共喝了幾瓶
		
		//如果還能繼續兌換可樂 就繼續除
		while(isContinue) {
			//總可樂數 = 滿的瓶子 + 空的瓶子
			colaAll = colaFullCount + colaNotFullCount;
			//滿的瓶子總數
			drinkCount += colaFullCount;
			//如果總共還有三瓶可樂以上 代表還可以繼續兌換
			if(colaAll >= 3) {
				//滿的瓶子 = 3個空瓶的商
				colaFullCount = colaAll / 3;
				//空的瓶子 = 全部的可樂/3取餘數
				colaNotFullCount = colaAll % 3;
			}else {
				//直到不能再除(不大於三)
				isContinue = false;
			}
		}
		//回傳喝了幾瓶可樂
		return drinkCount;
	}
	}
