package portfolio.homework_week06;

import java.util.Scanner;

public class Refrigerator extends HomeAppliance {
	
	Scanner scan = new Scanner(System.in);
	
	private boolean power = false;
	private int temperature = 18;
	private boolean freezer = true;
	
	public Refrigerator(String haName, int temperature) {
		super(haName);
		this.temperature = temperature;
//		this.freezer = freezer;
	}
	
	@Override
	public void showStatus() {
		String str = "전원 : "+power+"\n";
		str+="온도 : "+temperature+"\n";
		str+="냉동실 : "+freezer+"\n";
		System.out.println(str);
	}
	
	@Override
	public void menu() {
		while(true) {
			System.out.println("냉장고를 선택했습니다.");
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 전원 On/Off 2. 온도변경 3. 종료");
			int user = scan.nextInt();
			switch(user) {
				case 1 :
					System.out.println("전원 버튼을 누릅니다.");
					powerOnOff();
					showStatus();
					break;
					
				case 2 :
					System.out.println("온도를 변경합니다.");
					System.out.printf("현재 온도는 %d도 입니다. 원하는 동작을 선택해주세요.\n1. 온도상승 2.온도감소\n", this.temperature);
					int choice = scan.nextInt();
					
					if(choice==1) {
						System.out.println("온도를 1도 상승시킵니다.");
						temperatureUP();
						showStatus();
						break;
					}
					else if(choice==2) {
						System.out.println("온도를 1도 감소시킵니다.");
						temperatureDOWN();
						showStatus();
						break;
					}
				
				case 3 :
					System.out.println();
					freezerOnOff();
					return;
					
				default:
					System.out.println();
					System.out.println("번호를 확인 후 다시 입력해 주세요.");
			}
		}
	}
	
	public void powerOnOff() {
		power = !power;
	}
	
	public void temperatureUP(){
		if(power) {
			this.temperature++;
		}
	}
	
	public void temperatureDOWN(){
		if(power) {
			this.temperature--;
		}
	}
	
	public void freezerOnOff() {
		if(power) {
			freezer = !freezer;
		}
	}

//	@Override
//	public void turnOn() {
//		// TODO Auto-generated method stub
//		this.haPower = true;
//	}
//
//	@Override
//	public void turnOff() {
//		// TODO Auto-generated method stub
//		this.haPower = false;
//	}
//
//	@Override
//	public void control() {
//		// TODO Auto-generated method stub
//		this.menu();
//	}	
	

}
