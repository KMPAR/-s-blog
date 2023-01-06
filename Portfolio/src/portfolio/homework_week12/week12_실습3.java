package portfolio.homework_week12;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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


public class week12_실습3 extends JFrame {
	//카드 레이아웃 
	
	Color[] color = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.PINK, Color.GRAY};
	JPanel panel1, panel2;
	Container frame = this.getContentPane();
	
	CardLayout cl = new CardLayout();
	JPanel[] card;
	
	public week12_실습3() {
		this("200000 홍길동");
	}
	
	public week12_실습3(String title) {
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
		this.panel1 = new JPanel(new GridLayout(1, 3, 10, 10));
		
		JButton btn1 = new JButton("<<");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			cl.previous(panel2); //이전 카드를 보여줌 !
		}});
		JButton btn2 = new JButton("Home");
		btn2.addActionListener(e->cl.show(panel2, "3"));
		JButton btn3 = new JButton(">>");
		btn3.addActionListener(e->cl.next(panel2)); //다음 카드를 보여줌 !
		
		panel1.add(btn1);
		panel1.add(btn2);
		panel1.add(btn3);
		
		frame.add(panel1, BorderLayout.NORTH);
		
	}
	
	private void initPanel2() {
		// TODO Auto-generated method stub
		this.panel2 = new JPanel(cl);
		this.card = new JPanel[color.length];
		for(int i=0; i<color.length; i++) {
			card[i] = new JPanel();
			card[i].setBackground(color[i]);
			panel2.add(card[i], String.valueOf(i)); //int i를 string으로 바꿔줌 !
		}
		cl.show(panel2, "3"); //3번 패널을 화면에 보여주면서 시작함!
		frame.add(panel2, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new week12_실습3("20000 홍길동");

	}

}