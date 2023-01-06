package portfolio.homework_week06;

public class week06_팀과제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Home home = new Home(10);
		home.buyHA(new TV("건국TV", 15));
		home.buyHA(new Boiler("건국 보일러", 20));
		home.buyHA(new Refrigerator("건국냉장고", 0));
		home.buyHA(new cleaner("건국청소기", 0));
		home.buyHA(new TV("대학 TV", 10));
		
		IoTInterface iot = home.connect();
		if(iot != null) {
//			iot.turnOn();
			iot.control();
//			iot.turnOff();
		}
//		else
//			System.out.println("connect 실패 !");
		
//		IoTInterface ii = new IoTInterface() {
////익명 클래스가 만들어진 것.
//			@Override
//			public void turnOn() {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void turnOff() {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void control() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		};
	}
}
