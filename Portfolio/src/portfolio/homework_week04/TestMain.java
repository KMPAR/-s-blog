package portfolio.homework_week04;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("===== tv1 =====");
		TV tv1 = new TV();
//		tv1.powerOnOff();
		tv1.channelUp();
		tv1.channelUp();
		
		
		System.out.println("===== tv2 =====");
		TV tv2 = new TV();
//		tv2.powerOnOff();
		tv2.channelUp();
		tv2.channelUp();
		tv2.channelUp();
		
		System.out.println("===== tv1 = tv2 =====");
		System.out.println("tv1 : " + tv1);
		System.out.println("tv2 : " + tv2);
		tv1 = tv2;
		System.out.println("--------------");
		System.out.println("tv1 : " + tv1);
		System.out.println("tv2 : " + tv2);
		tv1.showTV();
	}

}

//class TV {
//	public boolean power;
//	public int channel;
//	
//	public void powerOnOff() {
//		power = !power;
//	}
//	public void channelUp() {
//		if(power)
//			++channel;
//		showTV();
//	}
//	public void channelDown() {
//		if(power)
//			--channel;
//		showTV();
//	}
//	
//	public void showTV() {
//		if(power)
//			System.out.println("채널 : " + channel + "시청 중");
//		else
//			System.out.println("전원이 꺼져있습니다.");
//	}
//}






// method overriding -> type 이 다른 것들도 넣을 수 있는 것???
// method 이름으 보통 소문자로 시작
// void 여도 return 이 가능하다

// TV 클래스에서 위에는 멤버 변수 밑에는 멤버 함수