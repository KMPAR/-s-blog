package portfolio.homework_week05;



public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankManager branch1 = new BankManager("건국대" , 5);
		branch1.createAccount();
		branch1.createAccount();
		branch1.deposit();
		branch1.withdraw();
		branch1.transfer();
	}

}

//class 정의할 때 public 이나 default(public을 생략한 것 = 아무것도 안쓸때)
//private - 클래스 내부에서만 사용가능. - 가장 강력함. 다른 클래스에서 접근 불가. - 객체 생성 제한.
//default(생략) - 동일 패키지 내부에서만 접근 가능. 외부 패키지에서 접근 불가.
//protected - 기본적으로는 default와 동일 = 동일 패키지 내부에서만 접근. but 외부 패키지의 클래스가 자식 클래스면 사용 가능(상속 관계에서는 사용 가능)

//만약 클래스가 default 면 생성자도 동일 패키지만 가능. (즉 public, protected 사용 불가 ??)

//앞으로 만드는 클래스의 변수들은 static이던 인스턴스던 private으로 만들어줘야 한다..

//싱글톤으로 객체 두개 만들어도 둘은 같은 객체이다. - 싱클톤 객체는 하나만 만들어지기 때문.

//항상 모든 클래스의 조상 클래스는 object클래스이다.
//★ 무조건 상속관계로 구현하면 안됨. -> 두 관계 사이에 is-a 관계 성립해야함. 즉, 같은 종류
//포함관계는 has-a 관계. 같은 종류가 아님.

//class인 경우 다중 상속 불가.