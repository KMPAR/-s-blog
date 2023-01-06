package portfolio.homework_week05;

public class BankAccount {
	private int accountNumber; 
	private String customerName;
	private double accountBalance;
	private static int count = 0;

	{
		this.accountNumber = ++count;
	}

	private BankAccount(String customerName) {
		this(customerName, 0);
	}

	private BankAccount(String customerName, double accountBalance) {
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}
	
	//static 멤버함수
	public static BankAccount getInstance(String name, double amount) {
		//BankAccount account = new BankAccount(name, amount;
		//return account;
		return new BankAccount(name, amount);
	}

	public void deposit(double amount) {
		this.accountBalance += amount;
	}
	
	public void withdraw(double amount) {
		if(this.accountBalance >= amount)
			this.accountBalance -= amount;
		else
			System.out.println("출금 잔액 부족");
	}
	
	public void transfer(BankAccount account, double amount) {
		if(this.accountBalance >= amount) {
			this.withdraw(amount);
			account.deposit(amount);
		}
		else
			System.out.println("이체 잔액 부족");
	}

	@Override //부모의 것 재정의하는거.
	public String toString() {
		String str = "계좌 번호 : " + this.accountNumber + "\n"; 
		str += "고객 이름 : " + this.customerName + "\n";
		str += "잔액 : " + this.accountBalance + "\n";
		
		return str; //super는 조상함수 가르키는 것.
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public static int getCount() {
		return count;
	}
	//static 맴버 변수가 private이면 static 멤버를 접근할 수 있는 static 함수를 만들어야 함..

//	public void setAccountNumber(int accountNumber) {
//		this.accountNumber = accountNumber;
//	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
//	public void setAccountBalance(double accountBalance) {
//		this.accountBalance = accountBalance;
//	}
//
//	public static void setCount(int count) {
//		BankAccount.count = count;
//	}	
}
