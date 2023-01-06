package portfolio.homework_week06;

import java.util.Scanner;

public class Home extends HomeAppliance implements IoTInterface{
	
	public static Scanner scan = new Scanner(System.in);

	private HomeAppliance[] HAs;
	private final int NUMBER;
	private int count = 0;
	
	public Home(int NUMBER) {
		super();
		this.NUMBER = NUMBER;
		HAs = new HomeAppliance[this.NUMBER];
	}
	
	public void buyHA(HomeAppliance HA) {
		if(this.count < this.NUMBER) {
			this.HAs[count++] = HA;
		}else
			System.out.println("공간이 없습니다.");
	}
	
	public void open() {
		while(true) {
			System.out.println("제어할 가전제품을 선택하세요!!");
			for(int i = 0; i<=NUMBER; i++) {
				if(HAs[i] != null) {
					System.out.println(i+1 + ")" + HAs[i].getHaName());
				}
				else
					break;
			}
			System.out.println("제품을 선택해 주세요");
			int num = scan.nextInt();	
			if(num>=1 && num <=count)
				HAs[num-1].menu();
			else {
				System.out.println("가전제품 제어를 종료합니다.");
			    break;
			}

		}
		
	}
	
	public IoTInterface connect() {
		while(true) {
			System.out.println("원격제어할 가전제품 선택하세요.");
			for(int i = 0; i<HAs.length; i++) {
				if(HAs[i] instanceof IoTInterface) {
					System.out.println(i+1 + ")" + HAs[i].getHaName());
				}
			}
			System.out.println("제품을 선택해 주세요");
			int num = scan.nextInt();	
			if(num>=1 && num <=count) {
				if(HAs[num-1] instanceof IoTInterface) {
					HAs[num-1].menu();
//					return (IoTInterface)HAs[num-1];
				}
				else {
					System.out.println("다시 선택해주세요");
				}
			}
			else {
				System.out.println("가전제품 제어를 종료합니다.");
				break;
			}
		}
		return null;
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void control() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showStatus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
