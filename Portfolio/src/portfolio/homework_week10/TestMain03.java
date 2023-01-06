package portfolio.homework_week10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class TestMain03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Word> list1 = new LinkedList<>();
		
		list1.add(new Word("green", "녹색"));
		list1.add(new Word("red", "빨강"));
		list1.add(new Word("blue", "파랑"));
		
		
		Iterator<Word> it = list1.iterator();
		while(it.hasNext()) {
			Word w = it.next();
			if(w.equals(new Word("red", "빨강")))
				it.remove();
		}
		System.out.println(list1);
		
		
		
		List<Integer> list2 = new LinkedList<>();

	}

}
