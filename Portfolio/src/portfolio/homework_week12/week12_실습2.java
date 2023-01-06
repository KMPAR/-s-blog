package portfolio.homework_week12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class week12_실습2 extends JFrame {
	//그리드 레이아웃
	
	String[] str = {"빨강", "초록", "파랑", "노랑", "핑크", "회색"};
	Color[] color = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.PINK, Color.GRAY};
	JPanel panel1, panel2;
	
	Container frame = this.getContentPane();
	
	public week12_실습2() {
		this("200000 홍길동");
	}
	
	public week12_실습2(String title) {
		super(title);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null); //창의 위치 설정 null 값 넣으면 화면 중앙에 뜬다
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init(); //init 호출함
		this.setVisible(true);
	}

	public void init() {
		// TODO Auto-generated method stub
		initPanel1();
		initPanel2();
		
	}

	private void initPanel1() {
		// TODO Auto-generated method stub
		this.panel1 = new JPanel(new GridLayout(1, str.length, 5, 5));
		for(int i = 0; i<str.length; i++) {
			final int idx = i;
			JButton btn = new JButton(str[i]);
			btn.addActionListener(e->panel2.setBackground(color[idx]));  //람다 표현식으로 표현하기 !
			
//			btn.addActionListener(new ActionListener() { //익명객체로 이벤트 구성!!
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					panel2.setBackground(color[idx]); //익명객체에서 외부에 있는 값은 모두 상수 취급이므로 변수 i를 쓰면 안되고 상수 idx를 따로 만들어줘야함!!
//					
//				}
//				
//			});
			this.panel1.add(btn);
		}
		frame.add(panel1, BorderLayout.NORTH);
	}
	
	private void initPanel2() {
		// TODO Auto-generated method stub
		this.panel2 = new JPanel();
		this.panel2.setBackground(Color.BLUE);
		frame.add(panel2, BorderLayout.CENTER);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new week12_실습2("20000 홍길동");

	}

}