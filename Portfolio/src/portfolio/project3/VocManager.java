package portfolio.project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class VocManager{
	private String userName;
	private HashMap<String, Word>voc = new HashMap<>();
	private HashMap<String, Word>korvoc = new HashMap<>();
	
	static Scanner scan = new Scanner(System.in);
	Random random = new Random();
	
	VocManager(String userName){
		this.userName = userName;
	}
	
	void addWord(Word word) {
		voc.put(word.eng, word);
	}
	
	void addWord1(Word word) {
		korvoc.put(word.kor, word);
	}
	
	void makeVoc(String fileName) {
		
		try(Scanner scan = new Scanner(new File(fileName))){
			while(scan.hasNextLine()) {
				String str = scan.nextLine();
				String[] temp = str.split("\t");
				this.addWord(new Word(temp[0].trim(), temp[1].trim()));
				this.addWord1(new Word(temp[0].trim(), temp[1].trim()));
			}
			System.out.println(userName+"의 단어장이 생성되었습니다.");
			this.menu();
			
		}catch(FileNotFoundException e) {
			System.out.println(userName+"의 단어장이 생성되지 않았습니다. \n파일명을 확인하세요.");
		}
		
	}
	
	void menu() {		
		int choice = 0;
		while(choice != 5) {	
			System.out.println("\n------"+userName+"의 영단어 퀴즈 -------");
			System.out.println("1) 주관식 퀴즈 2) 객관식 퀴즈 3) 오답노트 4) 단어검색 5) 종료");			
			System.out.print("메뉴를 선택하세요 : ");
			try {
				choice = scan.nextInt();
				scan.nextLine();
				System.out.println();

				switch (choice) {
				case 1:
					quiz1();
					break;
				case 2:
					quiz2();
					break;
				case 3:
					searchWrong();
					break;
				case 4:
					searchVoc();
					break;
				case 5:				
					System.out.println(userName + "의 단어장 프로그램을 종료합니다.");
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("\n1~5 사이의 숫자를 입력해주세요.");
				scan.nextLine();
			}
		}		
	}

	public void quiz1() {
		// TODO Auto-generated method stub
		int correct = 0;
		Object[] keys = korvoc.keySet().toArray();
		Object[] keys1 = voc.keySet().toArray();
		String[] randomKey = new String[10];
		for(int i = 0; i<10; i++) {
			randomKey[i] = (String) keys[random.nextInt(keys.length)];
			for(int j = 0; j < i; j++) {
				if(randomKey[i] == randomKey[j]) {
					i--;
					break;
				}
			}
		}
		
		long start = System.currentTimeMillis();
		for(int k = 0; k<10; k++) {	 
			System.out.println("----- 주관식 퀴즈 " + (k+1) + "번 -----");
			System.out.println("\"" + korvoc.get(randomKey[k]).kor + "\" 의 뜻을 가진 영어 단어는 무엇일까요?" ); 
			System.out.print("답을 입력하세요 : ");
			String answer = scan.nextLine();
			if(voc.get(answer) != null) {
				if(voc.get(answer).kor.equals(korvoc.get(randomKey[k]).kor)) {
					System.out.println("정답입니다.");
					for(int idx = 0; idx < keys1.length; idx++) {
						if(voc.get(keys1[idx]).kor.equals(voc.get(answer).kor)) {
							voc.get(keys1[idx]).num++;
						}
					}
					correct++;
				}else {
					System.out.println("틀렸습니다. 정답은 " + korvoc.get(randomKey[k]).eng + "입니다.");
					for(int idx = 0; idx < keys1.length; idx++) {
						if(voc.get(keys1[idx]).kor.equals(korvoc.get(randomKey[k]).kor)) {
							voc.get(keys1[idx]).num++; voc.get(keys1[idx]).wrong++;
						}
					}
				}
			}else {
				System.out.println("틀렸습니다. 정답은 " + korvoc.get(randomKey[k]).eng + "입니다.");
				for(int idx = 0; idx < keys1.length; idx++) {
					if(voc.get(keys1[idx]).kor.equals(korvoc.get(randomKey[k]).kor)) {
						voc.get(keys1[idx]).num++; voc.get(keys1[idx]).wrong++;
					}
				}
			}
		}
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println();
		System.out.println(userName + "님 10문제 중 " + correct + "개 맞추셨고, 총 " + (timeElapsed / 1000) + "초 소요되었습니다.");
		
	}
	
	public void quiz2() {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		int correct = 0;
		for(int i = 1; i<11; i++) {
			System.out.println("----- 객관식 퀴즈 " + i + "번 -----");
			
			Object[] keys =	korvoc.keySet().toArray();
			String[] randomKey = new String[4];
			for(int j = 0; j<4; j++) {
				randomKey[j] = (String) keys[random.nextInt(keys.length)];
				String english = korvoc.get(randomKey[j]).eng;
				for(int k = 0; k < j; k++) {
					if(randomKey[j] == randomKey[k]) {
						j--;
						break;
					}
				}
				voc.get(english).num++;
			}
			int rnd = random.nextInt(4);
			System.out.println(korvoc.get(randomKey[rnd]).eng + "의 뜻은 무엇일까요?");
			System.out.println("1) " + korvoc.get(randomKey[0]).kor);
			System.out.println("2) " + korvoc.get(randomKey[1]).kor);
			System.out.println("3) " + korvoc.get(randomKey[2]).kor);
			System.out.println("4) " + korvoc.get(randomKey[3]).kor);
			System.out.print("답을 입력하세요 : ");
			//InputMismatchException
			try{
				int answer = scan.nextInt();
				if(answer < 5) {
					if(korvoc.get(randomKey[rnd]).kor.equals(korvoc.get(randomKey[answer-1]).kor)) {
						System.out.println("정답입니다.");
						correct++;
					}else {
						System.out.println("틀렸습니다. 정답은 " + (rnd+1) + "번입니다.");
						String english = korvoc.get(randomKey[rnd]).eng;
						voc.get(english).wrong++;
					}
				}else {
					System.out.println("틀렸습니다. 정답은 " + (rnd+1) + "번 입니다.");
					String english = korvoc.get(randomKey[rnd]).eng;
					voc.get(english).wrong++;
				}	
			}catch(InputMismatchException e) {
				System.out.println("틀렸습니다. 정답은 " + (rnd+1) + "번 입니다.");
				String english = korvoc.get(randomKey[rnd]).eng;
				voc.get(english).wrong++;
				scan.nextLine();
			}
			
		}
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println();
		System.out.println(userName + "님 10문제 중 " + correct + "개 맞추셨고, 총 " + (timeElapsed / 1000) + "초 소요되었습니다.");
	}

	public void searchWrong() {
		// TODO Auto-generated method stub
		ArrayList<Word> list = new ArrayList<>();
		Object[] keys =	voc.keySet().toArray();
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i<keys.length; i++) {
			set.add(voc.get(keys[i]).wrong);
		}
		if(set.size()<2 && set.contains(0)) {
			System.out.println("틀린 단어가 없습니다.");
		}else {
			for(int j = 0; j<keys.length; j++) {
				if(voc.get(keys[j]).wrong != 0) {
					list.add(voc.get(keys[j]));
				}
			}
			Stream<Word> stream = list.stream();
			list.stream().sorted((o1, o2) -> (o1.wrong - o2.wrong)*-1).forEach(word ->  System.out.println(word.eng + " 뜻 : " + word.kor 
					+ "\n출제회수 : " + word.num  + "\t오답회수 : " + word.wrong + "\n-----------------------------" ));
		}
	}
	
	public void searchVoc() {
		// TODO Auto-generated method stub	
		System.out.println("------ 단어 검색 ------");
		System.out.print("검색할 단어를 입력하세요 : ");
		String sWord = scan.nextLine();
		sWord = sWord.trim();
		if(voc.containsKey(sWord)) {
			System.out.println(voc.get(sWord).eng + " 뜻 : " + voc.get(sWord).kor);
			System.out.println("출제회수 : " + voc.get(sWord).num + "\t오답회수 : " + voc.get(sWord).wrong);
		}else {
			System.out.println("단어장에 등록된 단어가 아닙니다.");
		}	
		System.out.println("-----------------------------");
	}
}