package portfolio.homework_week05;

import java.util.Scanner;


//import example05.homeapplianes.*;

public class BankManager {
	
	public String branchName; //지점명
		
	public int NUM;
	public int count = 0;
	
	public BankAccount[] bankAccount; //20개의 계좌정보 저장
	
	public TV tw = new TV();
	
	public static Scanner scan = new Scanner(System.in);
	
	public BankManager(String branchName, int num) {
		this.branchName = branchName;
		NUM = num;
		bankAccount = new BankAccount[NUM];
	}
	
	public void createAccount() {
		System.out.println("-------- 계좌 개설 --------");
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("입금할 금액 : ");
		double amount = scan.nextDouble();
		if(count < NUM) {
//			this.bankAccount[count++] = new BankAccount(name, amount);
			this.bankAccount[count++] = BankAccount.getInstance(name, amount); 
		}
		else
			System.out.println("계좌 개설 불가함");
	}
	
	public void deposit() {
		System.out.println("-------- 입금 --------");
		System.out.print("계좌번호 : ");
		int account = scan.nextInt();
		BankAccount target = findAccount(account);
		if(target != null) {
			System.out.print("입금할 금액 : ");
			double amount= scan.nextDouble();
			target.deposit(amount);
		}
		else
			System.out.println("계좌 번호 확인 요망");
	}
	
	public void withdraw() {
		System.out.println("-------- 출금 --------");
		System.out.print("계좌번호 : ");
		int account = scan.nextInt();
		BankAccount target = findAccount(account);
		if(target != null) {
			System.out.print("출금할 금액 : ");
			double amount= scan.nextDouble();
			target.withdraw(amount);
		}
		else
			System.out.println("계좌 번호 확인 요망");
	}

	public void transfer() {
		System.out.println("-------- 이체 --------");
		System.out.print("송금하는 계좌번호 : ");
		int account1 = scan.nextInt();
		System.out.print("송금받는 계좌번호 : ");
		int account2 = scan.nextInt();
		BankAccount target1 = findAccount(account1);
		BankAccount target2 = findAccount(account2);
		if(target1 != null) {
			if(target2 != null) {
				System.out.print("송금할 금액 : ");
				double amount= scan.nextDouble();
				target1.withdraw(amount);
				target2.deposit(amount);
			}
			else
				System.out.println("계좌 번호 확인 요망");	
		}
		else
			System.out.println("계좌 번호 확인 요망");	
	}

	public BankAccount findAccount(int account) {
		System.out.println("-------- 계좌 검색 --------");
		for(int i = 0; i<count; i++) {
			if(this.bankAccount[i].getAccountNumber() == account) {
				return this.bankAccount[i];
			}
		}
		return null;
	}
}
