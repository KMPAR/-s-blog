package portfolio.homework_week10;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TestMain01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Vector<Word> word = new Vector<>();
//		word.add(new Word("green", "녹색"));
//		word.add(new Word("red", "빨강"));
//		word.add(new Word("blue", "파랑"));
//
//		Word orange = new Word("orange", "오렌지");
//		word.add(1, orange);
//		
////	int index = word.indexOf(orange);
//		int index = word.indexOf(new Word("green", "초록"));
//		System.out.println(word.get(index));		//벡터 안에 값이 없으면 인덱스 -1을 반환
//		
//		
////	word.remove(orange);
//		
//		System.out.println(word);
		
		ArrayList<Word> word1 = new ArrayList<>();
		word1.add(new Word("green", "녹색"));
		word1.add(new Word("red", "빨강"));
		word1.add(new Word("blue", "파랑"));
		Word orange = new Word("orange", "오렌지");
		word1.add(1, orange);
		
		Word[] arr = word1.toArray(new Word[word1.size()]);
		for(Word w : arr) {
			System.out.println(w);
		}
		
//		int index = word1.indexOf(new Word("green", "녹색"));
//		System.out.println(word1.get(index));
		
//		word1.remove(new Word("green", "녹색"));
		
//		List<Word> list = word1.subList(1, 3);
//		ArrayList<Word> vec = new ArrayList<>(list);
//		System.out.println(vec);
		//System.out.println(list);
		
//		word1.subList(1, 3).clear();
		
		System.out.println(word1);
		
	}

}
