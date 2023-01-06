package portfolio.project_final;

import java.util.Random;
import java.util.Scanner;

public class bingocheck_연습 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random = new Random();
		
		int[][] bingo = new int[3][3];
		
		int[] randomKey = new int[9];
		for(int i = 0; i<9; i++) {
			randomKey[i] = random.nextInt(1, 11);
			for(int j = 0; j < i; j++) {
				if(randomKey[i] == randomKey[j]) {
					i--;
					break;
				}
			}
		}
		int num = 0;
		for(int i = 0; i<bingo.length; i++) {
			for(int j = 0; j<bingo[i].length; j++) {
				bingo[i][j] = randomKey[num];
				num++;
			}
		}
		
		for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo[i].length; j++) {
                System.out.print(bingo[i][j] + "\t"); // 열 출력
            }
            System.out.println(); // 행 출력
        }
		int e = 0;
		while(e == 0) {
			System.out.print("입력 : ");
			int select = scan.nextInt();
			for(int i = 0; i<bingo.length; i++) {
				for(int j = 0; j<bingo[i].length; j++) {
					if(bingo[i][j] == select)
						bingo[i][j] = 0;
				}
			}
			
			for (int i = 0; i < bingo.length; i++) {
	            for (int j = 0; j < bingo[i].length; j++) {
	                System.out.print(bingo[i][j] + "\t"); // 열 출력
	            }
	            System.out.println(); // 행 출력
			}
			
			int check = 0; int total = 0;
			for(int i = 0; i<bingo.length; i++) {
				for(int j = 0; j<bingo[i].length; j++) {
					if(bingo[i][j] == 0) {
						check++;
					}
				}
				if(check == 3) {
					total++;
				}
				check = 0;
			}
			check = 0;
			for(int i = 0; i<bingo.length; i++) {
				for(int j = 0; j<bingo[i].length; j++) {
					if(bingo[j][i] == 0) {
						check++;
					}
				}
				if(check == 3) {
					total++;
				}
				check = 0;
			}
			check = 0;
			for(int i = 0; i<bingo.length; i++) {
				if(bingo[i][i] == 0) {
					check++;
				}
				if(check == 3) {
					total++;
				}
			}
			check = 0;
			for(int i = 0; i<bingo.length; i++) {
				if(bingo[i][2-i] == 0) {
					check++;
				}
				if(check == 3) {
					total++;
				}
			}
			if(total > 0) {
				System.out.println(total + "빙고");
				e++;
			}
		}
	}
}
