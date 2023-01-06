package portfolio.homework_week05;

import java.util.Scanner;

public class week05_과제1 {
	
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202211415 박규민");
		
		System.out.println("**** 팀 생성 ****");
		System.out.print("팀원 수 : ");
		int number = scan.nextInt();
		SalesReport team1 = new SalesReport(number);
		
		team1.computStats();
		
		System.out.println();
		System.out.println("**** 최고사원 정보 ****");
		System.out.println(team1.getBestClerk());
		
		System.out.println();
		System.out.println("**** 팀 정보 ****");
		System.out.println(team1);
	}
}
