package portfolio.homework_week05;

import java.util.Scanner;

public class Salesman {
	private String name;
	private double sales;
	
	public static Scanner scan = new Scanner(System.in);
	
	public Salesman(String name, double sales) {
		
		this.name = name;
		this.sales = sales;
	}

	public Salesman() {
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void readInput() {
		System.out.print("이름 : ");
		this.name = scan.next();
		System.out.print("실적 : ");
		this.sales = scan.nextDouble();
	}

	@Override
	public String toString() {
		String str = "이름 : " + this.name + " /  ";
		str += "실적 : " + this.sales;
		return str;
	}

	public String getName() {
		return name;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}	
}
