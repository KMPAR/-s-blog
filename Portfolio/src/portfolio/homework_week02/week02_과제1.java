package portfolio.homework_week02;

import java.util.Scanner;

public class week02_과제1 {
	
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202211415 박규민");
		
		System.out.print("학번 : ");
		String num = scan.next();
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("나이 : ");
		int age = scan.nextInt();
		scan.nextLine();
		System.out.print("주소 : ");
		String address = scan.nextLine();
		
		System.out.println("학번 : " + num);
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("주소 : " + address);
	}
}

