package portfolio.homework_week05;

public class practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] lotto = new int[] {100, 600, 300};
		
		for(int i = 0; i<lotto.length; i++) {
			for(int j = 0; j<lotto.length; j++) {
				if(lotto[i]>lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
		
		
		
	}

}
