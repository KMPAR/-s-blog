package portfolio.homework_week10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new LinkedList<>();
		long starttime, endtime;
		
		starttime = System.nanoTime();
		for(int i = 0; i<10000; i++) {
			list1.add(i);
		}
		endtime = System.nanoTime();
		System.out.println("시간 : " + (endtime - starttime));
		
		starttime = System.nanoTime();
		for(int i = 0; i<10000; i++) {
			list2.add(i);
		}
		endtime = System.nanoTime();
		System.out.println("시간 : " + (endtime - starttime));
	}

}
