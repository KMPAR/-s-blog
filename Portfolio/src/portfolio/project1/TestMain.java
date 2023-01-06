package portfolio.project1;

import java.util.Random;
import java.util.Scanner;

public class TestMain {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202211415 박규민");
		
		while(true) {
			System.out.println();
			System.out.println("1) 쿠폰으로 초콜릿 구매하기 " + "2) 문자 산수 퍼즐 " + "3) 구구단 출력하기 " + "4) 종료");
			System.out.print("메뉴를 선택하세요 : ");
			int menu = scan.nextInt();
			System.out.println();
			
			switch(menu) {
			case 1:
				System.out.println("문제1. 쿠폰으로 초콜릿 구매하기");
				System.out.print("돈을 넣어주세요 : ");
				int money = scan.nextInt();
				System.out.println("--------------------");
				int choco = money;
				int allCoupon = money;
				
				while(allCoupon > 7) {
					int newChoco = allCoupon / 7;
					int newCoupon = newChoco;
					int restCoupon = allCoupon - newCoupon * 7;
					allCoupon = newCoupon + restCoupon;
					choco += newChoco;	
				}
				System.out.println("초콜릿 " + choco + "개, 쿠폰 " + allCoupon +"개");
				System.out.println("--------------------");
				
				break;
			case 2:
				int[] TOOGOOD = new int [7];
				Random r = new Random();
				
				while(true) {
					for(int i=0;i<7; i++) {
						while(TOOGOOD[0] == 0 && TOOGOOD[3] == 0) {
							TOOGOOD[i] = r.nextInt(10);
							for (int j=0; j<i; j++) {
								if (TOOGOOD[i] == TOOGOOD[j]) {
									i--;
									
									break;
								}
							}
						}
					}
					TOOGOOD[2] = TOOGOOD[1] ;
					TOOGOOD[4] = TOOGOOD[1] ;
					TOOGOOD[5] = TOOGOOD[1] ;
					
					int TOO = TOOGOOD[0] * 100 + TOOGOOD[1] * 10 + TOOGOOD[2] ;
					int GOOD = TOOGOOD[3] * 1000 + TOOGOOD[4] * 100 + TOOGOOD[5] * 10 + TOOGOOD[6];
					if(4*TOO == GOOD)
						break;
					else {
						for(int i=0;i<7; i++) {
							TOOGOOD[i] = r.nextInt(10);
							for (int j=0; j<i; j++) {
								if (TOOGOOD[i] == TOOGOOD[j]) {
									i--;
									
									break;
								}
							}
						}
					}	
				}
				System.out.print("해법 : ");
				System.out.println("T = "+ TOOGOOD[0] +  " O = "+TOOGOOD[1]+" G = "+TOOGOOD[3]+" D = "+TOOGOOD[6]);
			
				break;
			case 3:
				System.out.println("===== 구구단 출력하기 =====");
				System.out.print("출력 단수 : ");
				int num = scan.nextInt();
				int a = 1;
				while(a == 1) {
					if(num<1 || num>8) {
						System.out.println("출력 단 수 입력이 잘못되었습니다.");
						System.out.println("출력 단수 : ");
						num = scan.nextInt();
					}
					else {
						for(int j = 1; j<10; j++) {
							int NUM = 2;
							if(NUM>9) break;							
							for(int i = NUM; i<num+2; i++) {
								if(j>9) break;
								System.out.print(i+" * "+j+" = "+j*i);
								System.out.print("\t");
								
							}
						
						System.out.println();
							
						}
						System.out.println();
						for(int j = 1; j<10; j++) {
							int NUM = 2 + num;
							if(NUM>9) break;
							for(int i = NUM; i<10; i++) {
								if(j>9)break;
								System.out.print(i+" * "+j+" = "+j*i);
								System.out.print("\t");
							}
						System.out.println();
						}
						a ++;
					}
				}
				
				break;
				
			case 4:
				scan.close();
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");
				System.out.println();
			}
		}
	}
	

}

