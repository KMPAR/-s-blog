package portfolio.homework_week03;

public class week03_과제2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("202221415 박규민");
		lab02();
	}
	public static void lab02() {
		// TODO Auto-generated method stub
		
		String[] stdName = new String[] {"홍길동", "고길동", "김길동", "이길동"};
		int[][] score = new int[][] {{10, 20, 30, 0, 1},
			{20, 30, 40, 0, 1},
			{10, 25, 30, 0, 1},
			{30, 30, 40, 0, 1}};
			
		for(int[] arr : score) {          
			for(int i=0; i<arr.length-2; i++) {
				arr[arr.length-2]+=arr[i];     
			}
		}
				
		for(int i=0; i<score.length; i++) {      
			for(int j=0; j<score.length; j++) {
				if(score[i][score.length-1]<score[j][score.length-1])
					score[i][score.length]++;
			}
		}
					
		for(int i=0; i<score.length; i++) {
			System.out.print(stdName[i]+" >> ");
					
			int k=0;
			for(int j : score[i] ) {
				
				if(k==3||k==4)
					System.out.print(": ");
					
				System.out.print(j+" ");
				k++;
			}
			System.out.println();
		}						
	}			
}

