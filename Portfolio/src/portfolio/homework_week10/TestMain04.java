package portfolio.homework_week10;

import java.util.*;


public class TestMain04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Word> set = new HashSet<>();
		set.add(new Word("green", "녹색"));
		set.add(new Word("red", "빨강"));
		set.add(new Word("blue", "파랑"));
		set.add(new Word("green", "녹색"));
		set.add(new Word("red", "빨강"));
		set.add(new Word("blue", "파랑"));
		
		System.out.println(set);
		
		for(Word w : set) {
			System.out.println(w);
		}
		
//		Iterator<Word> it = set.iterator();
//		while(it.hasNext()) {
//			Word w = it.next();
//			if(w.equals(new Word("red", "빨강")))
//				it.remove();
//		}
//		System.out.println(set);
	}

}
