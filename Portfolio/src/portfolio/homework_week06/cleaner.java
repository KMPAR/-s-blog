package portfolio.homework_week06;

import java.util.Scanner;

public class cleaner extends HomeAppliance implements IoTInterface {
	Scanner scan = new Scanner(System.in);
	
	private int P;//청소기 세기
	
	public cleaner(String name, int P) {
		super(name);
		this.haName = name;
		this.P = P;
	}
	
	@Override
	public void showStatus() {
		System.out.println("이름 : "+super.getHaName());
		if(super.isHaPower()) {
			System.out.println("전원이 켜져있습니다.");
			System.out.println("세기 : "+P);
		}
		else
			System.out.println("전원이 꺼져있습니다.");
		
	}
	
	@Override
	public void menu() {
		while(true) {
			System.out.println("1) 전원설정 2) 세기설정 3) 종료");
			int num = scan.nextInt();
			switch(num){
			case 1 :
				boolean power = !super.haPower;
				super.setHaPower(power);
				showStatus();
				break;
			case 2 :
				System.out.println("세기를 입력하세요.");
				int p = scan.nextInt();
				this.changepower(p);
				showStatus();
				break;
			case 3 :
				return;
			default:
				System.out.println();
				System.out.println("잘못 입력했습니다.");
			}
		}
	}
	
	public void changepower(int p) {
		if(isHaPower()==true) {
			P=p;
		}else
			System.out.println("전원이 꺼져있습니다.");
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		this.haPower = true;
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		this.haPower = false;
	}

	@Override
	public void control() {
		// TODO Auto-generated method stub
		this.menu();
	}
}
