package portfolio.project_final;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class BingoManager3{
	private String userName;
	private HashMap<String, Word>voc = new HashMap<>();
	private int n;
	String[][] bingospace;
	String[][] comspace;
	String[] randomKey;
	private int end = 0;
	private int gamenum = 0;
	private int win = 0; private int lose = 0; 
	private int e;
	

	static Scanner scan = new Scanner(System.in);
	Random random = new Random();
	
	BingoManager3(String userName){
		this.userName = userName;
	}
	
	void addWord(Word word) {
		voc.put(word.eng, word);
	}
	
	void makeVoc(String fileName) {
		
		try(Scanner scan = new Scanner(new File(fileName))){
			while(scan.hasNextLine()) {
				String str = scan.nextLine();
				String[] temp = str.split("\t");
				this.addWord(new Word(temp[0].trim(), temp[1].trim()));
				
			}
			this.menu();
		}catch(FileNotFoundException e) {
		}		
	}

	void menu() {		
		int end = 0;
		while(end == 0) {	
			System.out.println("\n------"+userName+"의 빙고 프로그램 -------");
			System.out.println("새로운 게임을 시작하시겠습니까? (Y/N)");			
			try {
				String choice = scan.next();
				scan.nextLine();
				System.out.println();

				switch (choice) {
				case "Y":
					e = 0;
					bingo();
					break;
				case "N":
					System.out.println(userName + "의 빙고 프로그램을 종료합니다.");
					end++;
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("\n2 이상의 숫자를 입력해주세요.");
				scan.nextLine();
			}
		}		
	}

	void bingo() {
		// TODO Auto-generated method stub
		System.out.print("배열의 크기를 입력해주세요 : ");
		n = scan.nextInt();
		scan.nextLine();
		
		this.makebingo();
		System.out.println("[사용자 빙고판]");
		this.showbingo(bingospace);
		
		System.out.println("\n[컴퓨터 빙고판]");
		this.showbingo(comspace);
		
		end = 0;
		while(end == 0) {
			
			//빙고 입력
			this.putbingo();
			
			//빙고 체크
			this.checkbingo();
		}
		this.gamenum++;
		this.showStatus();
	}

	private void showbingo(String[][] array) {
	// TODO 빙고판 출력
				
		for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t\t\t"); // 열 출력
            }
            System.out.println(); // 행 출력
        }
	}

	private void makebingo() {
		// TODO 빙고판 생성
		
		bingospace = new String[n][n];
		comspace = new String[n][n];
		
		int scale = n*n;
		
		Object[] keys = voc.keySet().toArray();
		randomKey = new String[scale];
		
		for(int i = 0; i<scale; i++) {
			randomKey[i] = (String) keys[random.nextInt(keys.length)];
			for(int j = 0; j < i; j++) {
				if(randomKey[i] == randomKey[j]) {
					i--;
					break;
				}
			}
		}
		
		int num = 0;
		for(int row = 0; row<bingospace.length; row++) {
			for(int col=0; col<bingospace[row].length; col++) {
				bingospace[row][col] = randomKey[num];
				num++;
			}
		}
		
		for(int i = 0; i<scale; i++) {
			randomKey[i] = (String) keys[random.nextInt(keys.length)];
			for(int j = 0; j < i; j++) {
				if(randomKey[i] == randomKey[j]) {
					i--;
					break;
				}
			}
		}
		
		num = 0;
		for(int row = 0; row<comspace.length; row++) {
			for(int col=0; col<comspace[row].length; col++) {
				comspace[row][col] = randomKey[num];
				num++;
			}
		}
	}
	
	private void showStatus() {
		double percent = (double) win/ (double) gamenum * 100.0;
		String str = "\n전적 : " + win + "승 " + lose + "패 " + (gamenum-(win+lose)) + "무\n";
		str += "승률 : " + String.format("%.2f", percent) + "%";
		System.out.println(str);
	}
	
	private void putbingo() {
		//컴퓨터 빙고 입력
		System.out.println("----- 컴퓨터 선택 -----");
		
		//컴퓨터 승리 알고리즘
		String word1 = null;
		int ROW = 0; int COL = 0;
		ArrayList<String> rndword1 = new ArrayList<String>();
		ArrayList<String> rndword2 = new ArrayList<String>();
		ArrayList<String> rndword3 = new ArrayList<String>();
		ArrayList<String> rndword4 = new ArrayList<String>();
		
		if(e == 0) {
			word1 = randomKey[random.nextInt(randomKey.length)];
			e++;
		}else {
			for(int i = 0; i<comspace.length; i++) {
				for(int j = 0; j<comspace[i].length; j++) {
					if(comspace[i][j].equals("O")) {
						ROW = i; COL = j;
					}
				}
			}
			
			System.out.println("(" + ROW + "," + COL + ")");
			
			for(int i = 0; i<comspace.length; i++) {
				if(!comspace[ROW][i].equals("O"))
					rndword1.add(comspace[ROW][i]);	
				
				if(!comspace[i][COL].equals("O")) 
					rndword2.add(comspace[i][COL]);
				
				if(ROW == COL) {
					if(!comspace[i][i].equals("O"))
						rndword3.add(comspace[i][i]);
				}
				if(ROW + COL == n-1) {
					if(!comspace[i][n-1-i].equals("O")) {
						rndword4.add(comspace[i][n-1-i]);
					}
				}
			}
			
			int size1 = rndword1.size(); int size2 = rndword2.size(); int size3 = rndword3.size(); int size4 = rndword4.size();
			if(size1 == 0) size1 = n; 
			if(size2 == 0) size2 = n;
			if(size3 == 0) size3 = n;
			if(size4 == 0) size4 = n;
			
			if(size1 <= size2 && size1 <= size3 && size1 <= size4) {
				try {
				word1 = rndword1.get(random.nextInt(size1)); 
				}catch(IndexOutOfBoundsException e) {
					for(int i = 0; i <comspace.length; i++) {
						for(int j = 0; j<comspace[i].length; j++) {
							if(comspace[i][j] != "O") {
								word1 = comspace[i][j];
								break;
							}
						}
					}
				}
			}		
			else if(size2 < size1 && size2 <= size3 && size2 <= size4) 
				word1 = rndword2.get(random.nextInt(size2));

			else if(size3 < size1 && size3 < size2 && size3 <= size4) 
				word1 = rndword3.get(random.nextInt(size3));
			
			else if(size4 < size1 && size4 < size2 && size4 < size3) 
				word1 = rndword4.get(random.nextInt(size4));
		}
		System.out.println(word1);
		System.out.println();
		for(int row = 0; row<bingospace.length; row++) {
			for(int col=0; col<bingospace[row].length; col++) {
				if(bingospace[row][col].equals(word1)) {
					bingospace[row][col] = "O";
				}
				if(comspace[row][col].equals(word1)) {
					comspace[row][col] = "O";
				}
			}
		}
		
		//사용자 빙고 입력
		System.out.println("----- 사용자 선택 -----");
		System.out.print("단어를 입력해주세요 : ");
		String word2 = scan.nextLine();
		
		for(int row = 0; row<bingospace.length; row++) {
			for(int col=0; col<bingospace[row].length; col++) {
				if(bingospace[row][col].equals(word2)) {
					bingospace[row][col] = "O";
					System.out.println("\"" + voc.get(word2) + "를 선택하였습니다. \"");
					System.out.println();
				}
				if(comspace[row][col].equals(word2)) {
					comspace[row][col] = "O";
				}
			}
		}
		System.out.println("[사용자 빙고판 현황]");
		this.showbingo(bingospace);
		System.out.println();
		
		System.out.println("[컴퓨터 빙고판 현황]");
		this.showbingo(comspace);
		System.out.println();
	}
	
	private void checkbingo() {
		int check; int usck = 0; int comck = 0;
		
		check=0;
		for(int i = 0; i<bingospace.length; i++) {
			for(int j = 0; j<bingospace[i].length; j++) {
				if(bingospace[i][j] == "O") {
					check++;
				}
			}
			if(check == n) {
				usck++;
			}
			check = 0;
		}
		check = 0;
		for(int i = 0; i<bingospace.length; i++) {
			for(int j = 0; j<bingospace[i].length; j++) {
				if(bingospace[j][i] == "O") {
					check++;
				}
			}
			if(check == n) {
				usck++;
			}
			check = 0;
		}
		check = 0;
		for(int i = 0; i<bingospace.length; i++) {
			if(bingospace[i][i] == "O") {
				check++;
			}
			if(check == n) {
				usck++;
			}
		}
		check = 0;
		for(int i = 0; i<bingospace.length; i++) {
			if(bingospace[i][n-1-i] == "O") {
				check++;
			}
			if(check == n) {
				usck++;
			}
		}
		
		//컴퓨터 빙고 체크
		check=0;
		for(int i = 0; i<comspace.length; i++) {
			for(int j = 0; j<comspace[i].length; j++) {
				if(comspace[i][j] == "O") {
					check++;
				}
			}
			if(check == n) {
				comck++;
			}
			check = 0;
		}
		check = 0;
		for(int i = 0; i<comspace.length; i++) {
			for(int j = 0; j<comspace[i].length; j++) {
				if(comspace[j][i] == "O") {
					check++;
				}
			}
			if(check == n) {
				comck++;
			}
			check = 0;
		}
		check = 0;
		for(int i = 0; i<comspace.length; i++) {
			if(comspace[i][i] == "O") {
				check++;
			}
			if(check == n) {
				comck++;
			}
		}
		check = 0;
		for(int i = 0; i<comspace.length; i++) {
			if(comspace[i][n-1-i] == "O") {
				check++;
			}
			if(check == n) {
				comck++;
			}
		}
		
		if(usck > 0 || comck > 0) {
			if(usck > comck) {
				System.out.println(usck + "빙고 사용자 승리\n\n [사용자 빙고판]");
				this.showbingo(bingospace);
				this.win++;
				end++;
			}else if(usck < comck){
				System.out.println(comck + "빙고 컴퓨터 승리\n\n [컴퓨터 빙고판]");
				this.showbingo(comspace);
				this.lose++;
				end++;
			}
		}
		if(usck == (n*2)+2 && comck == (n*2)+2) {
			System.out.println("무승부");
			this.showbingo(bingospace);
			end++;
		}
	}
}