package portfolio.homework_week04;

//문자 치환하기
public class ChangeChar {
	public void replaceChar(char[] str, char c, char d) {//배열, 바꿀 문자, 바꾸고 싶은 문자
		for(int i = 0; i < str.length; i++) {
			if(str[i] == c) 
				str[i] = d;
		}
	}
	public char[] replaceChar(String str, char c, char d) {
		char[] cstr = str.toCharArray(); //새로운 객체를 만들어줌.
		replaceChar(cstr, c, d); 
		return cstr; 
	}
}
