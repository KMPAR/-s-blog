package portfolio.project3;

public class Word implements Comparable<Word>{
	String eng;
	String kor;
	int num;
	int wrong;
	
	public Word(String eng, String kor) {
		super();
		this.eng = eng;
		this.kor = kor;
		this.num = 0;
		this.wrong = 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub		
		return eng+" 뜻 : "+kor;
	}

	@Override
	public int compareTo(Word o) {
		// TODO Auto-generated method stub
		return (this.wrong - o.wrong) * -1;
	}	
}


