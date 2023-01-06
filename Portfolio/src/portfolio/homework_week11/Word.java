package portfolio.homework_week11;

public class Word implements Comparable<Word>{
	String eng;
	String kor;
	int num;
	
	public Word(String eng, String kor) {
		super();
		this.eng = eng;
		this.kor = kor;
		this.num = 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub		
		return eng+" : "+kor;
	}

	@Override
	public int compareTo(Word o) {
		// TODO Auto-generated method stub
		return (this.num - o.num) * -1;
	}	
}
