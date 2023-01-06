package portfolio.homework_week06;

import java.util.Scanner;

public class Boiler extends HomeAppliance implements IoTInterface{
	
	public static Scanner scan = new Scanner(System.in);


	private int tem;
	
	public Boiler(String haName, int tem) {
		super(haName);
		this.tem = tem;
	}
	
	public void changeTem(int tem) {
		if(super.isHaPower()) {
			this.tem = tem;
		}else {
			System.out.println("전원이 꺼져있습니다.");
			System.out.println();
		}
	}

	@Override
	public void showStatus() {
		System.out.println("이름 : " + super.getHaName());
		if(super.isHaPower()) {
			System.out.println("전원이 켜져있습니다.");
		}else
			System.out.println("전원이 꺼져있습니다.");
		System.out.println("온도 : " + tem);
		
	}

	@Override
	public void menu() {
		while(true) {
			System.out.println("보일러를 제어합니다.");
			System.out.println("1) 전원 설정  2) 온도 설정  3) 종료" );
			int num = scan.nextInt();
			switch(num) {
			case 1 : 
				boolean power = !super.isHaPower();
				super.setHaPower(power);
				showStatus();
				break;
			
			case 2 : 
				int tem = scan.nextInt();
				System.out.print("원하는 온도를 선택해주세요 : ");
				this.changeTem(tem);
				showStatus();
				break;
			
			case 3 :				
				return;
			
			default:
				System.out.println();
				System.out.println("번호를 확인 후 다시 입력해 주세요.");
			}
		}
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
