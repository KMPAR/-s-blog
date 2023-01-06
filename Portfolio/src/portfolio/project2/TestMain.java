package portfolio.project2;

import java.util.Arrays;
import java.util.Scanner;

public class TestMain {
	
	static final int ROW = 4;
	static final int COL = 3;

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202211415 박규민");
		String[][] parkingSpace = new String[ROW][COL];
		String[][] carNum = new String[ROW][COL];
		
		for(int i = 0; i<4; i++) {
			Arrays.fill(parkingSpace[i], "♡");
		}
		while(true) {
			System.out.println("**** 주차 현황 ****");
			System.out.println("  " + "1 2 3");
			System.out.println("1 " + parkingSpace[0][0] + " " + parkingSpace[0][1] + " " + parkingSpace[0][2]);
			System.out.println("2 " + parkingSpace[1][0] + " " + parkingSpace[1][1] + " " + parkingSpace[1][2]);
			System.out.println("3 " + parkingSpace[2][0] + " " + parkingSpace[2][1] + " " + parkingSpace[2][2]);
			System.out.println("4 " + parkingSpace[3][0] + " " + parkingSpace[3][1] + " " + parkingSpace[3][2]);
			
			System.out.println();
			System.out.println("1) 주차하기 " + "2) 차량검색 " + "3) 출차하기 " + "4) 종료");
			System.out.print("메뉴를 선택하세요 : ");
			int menu = scan.nextInt();
			System.out.println();
			
			switch(menu) {
			case 1:
				System.out.println("**** 주차하기 ****");
				System.out.print("주차할 위치를 선택해 주세요(입력예 : 2 1) : ");
				int row = scan.nextInt();
				int col = scan.nextInt();
				
				if(row>4 || row<1 || col>3 || col<1) {
					System.out.println("위치 번호를 확인해주세요. 처음부터 다시 시작해주세요.");
					break;
				}
				
				else if(parkingSpace[row-1][col-1] == "♥") {
					System.out.println("다른 차량이 주차되어 있습니다. 처음부터 다시 시작해주세요.");
					break;
				}
				else {
					System.out.print("차량 번호를 입력해 주세요(입력예 : 20가1234) : ");
					String car_num = scan.next();
					
					System.out.print("차량 번호 " + car_num + " 맞습니까(y/n)? ");
					String check = scan.next();
					
					String check1 = "n";
					
					if(check.equals(check1)) {
						System.out.println("처음부터 다시 진행해 주세요.");
						break;
					}
					
					else {
						System.out.println(car_num + " 차량의 주차를 완료하였습니다.");
						System.out.println();
						carNum[row-1][col-1] = car_num;
						
						if(parkingSpace[row-1][col-1] == "♡")
							parkingSpace[row-1][col-1] = "♥";
						break;
					}
				}
			
			case 2:
				System.out.println("**** 차량검색 ****");
				System.out.print("차량 번호를 입력해 주세요. : ");
				String car_num = scan.next();
				
				int a = 1;
				loopOut1: while(a == 1) {
					for(int i = 0; i<ROW; i++) {
						for(int j = 0; j<COL; j++) {
							if(car_num.equals(carNum[i][j])) {
								i += 1; j += 1;
								System.out.println(car_num +"는 (" + i + ", " + j + ")에 위치합니다.");
								break loopOut1;
							}
						}
					}
					a++;
					System.out.println("차량이 존재하지 않습니다. 차량번호 확인 후 처음부터 다시 진행해 주세요.");
					System.out.println();
				}
				break;
			
			case 3:
				System.out.println("**** 출차하기 ****");
				System.out.print("차량 번호를 입력해 주세요. : ");
				car_num = scan.next();
				
				int b = 1;
				loopOut2: while(b == 1) {
					for(int i = 0; i<ROW; i++) {
						for(int j = 0; j<COL; j++) {
							if(car_num.equals(carNum[i][j])) {
								System.out.println(car_num +"는 출차되었습니다.");
								
								carNum[i][j] = "empty";
								if(parkingSpace[i][j] == "♥")
									parkingSpace[i][j] = "♡";
								break loopOut2;
							}
						}
					}
					b++;
					System.out.println("차량이 존재하지 않습니다. 차량번호 확인 후 처음부터 다시 진행해 주세요.");
					System.out.println();
				}
				break;
			
			case 4:
				scan.close();
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			
			default:
				System.out.println();
				System.out.println("메뉴 번호를 확인 후 다시 입력해 주세요.");
			}
		}	
	}
}
