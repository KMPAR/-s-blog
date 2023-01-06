package portfolio.homework_week04;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int level = 1;
		for(int i = 0; i<6; i++) {
			if(level < 3) {
				level ++;
				System.out.println(level);
			}
			else {
				level = 1;
				System.out.println(level);
			}
		}
	}

		
}
