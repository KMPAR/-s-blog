package portfolio.homework_week06;

import java.util.Scanner;

public class TV extends HomeAppliance {
	
	Scanner scan = new Scanner(System.in);



	private int channel;
	
	public TV(String haName, int channel) {
		super(haName);
		this.channel = channel;
	}

	public void powerOnOff() {
		super.haPower=!super.haPower;
	}
	
	public void channelUp() {
		if(haPower==true)
			this.channel++;
	}
	
	public void channelDown() {
		if(haPower==true)
			this.channel--;
	}
	
	public void channelChange() {
		if(haPower==true) {
			System.out.print("채널 번호 : ");
			int num=scan.nextInt();
			this.channel = num;
		}
	}
	
	
	
	@Override
	public void showStatus() {
		System.out.println("제품명 : "+super.haName);
		System.out.println("전원 : "+super.haPower);
		System.out.println("채널 : "+this.channel);
	}

	@Override
	public void menu() {
		while(true) {
			System.out.println();
			System.out.println("1)전원 On/Off");
			System.out.println("2)채널 Up");
			System.out.println("3)채널 Down");
			System.out.println("4)채널 바꾸기(입력)");
			System.out.println("5)종료");
			System.out.print("메뉴선택 : ");
			int n=scan.nextInt();
			switch(n) {
			case 1:	this.powerOnOff(); break;
			case 2:	this.channelUp(); break;
			case 3:	this.channelDown(); break;
			case 4:	this.channelChange(); break;
			case 5: return;
			default: break;				
			}
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
