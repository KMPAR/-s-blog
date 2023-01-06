package portfolio.homework_week04;

import java.util.Arrays;
import java.util.Scanner;

public class TestMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = scan.nextLine();
		System.out.print("찾을 문자 : ");
		String cstr = scan.nextLine();
		System.out.print("바꿀 문자 : ");
		String dstr = scan.nextLine();
		
		ChangeChar changeStr = new ChangeChar();
		char[] result = changeStr.replaceChar(str, cstr.charAt(0), dstr.charAt(0));
		System.out.println(result); 
		//int배열은 주소를 출력하지만, char배열은 문자열이 출력됨
		
		int[] arr = {1,2,3,4};
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));
	}

}
