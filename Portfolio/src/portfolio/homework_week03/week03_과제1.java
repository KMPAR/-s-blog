package portfolio.homework_week03;

import java.util.Random;

public class week03_과제1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202211415 박규민");
		lab01();
	}
	
	public static void lab01() {
		int[] lotto = makeLotto();
		
		for(int i=0; i<lotto.length-1; i++) {      
			int minIndex = i;
			for(int j=i+1; j<lotto.length; j++) {
				if(lotto[j] < lotto[minIndex])
					minIndex = j;
			}
			if(minIndex != i) {
				int temp = lotto[minIndex];
				lotto[minIndex] = lotto[i];
				lotto[i] = temp;
			}
		}
		System.out.print("로또번호: ");
		for ( int i : lotto)
			System.out.print(i+" ");
	}
	
	public static int[] makeLotto() {
		int[] lotto = new int[6];
		Random random = new Random();
		
		for(int i=0; i<lotto.length; i++) {
			lotto[i]= random.nextInt(45)+1;
			
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;      
				}					
			}
		}
		return lotto;
	}
}
