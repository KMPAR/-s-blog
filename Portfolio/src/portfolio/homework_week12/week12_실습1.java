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

public class week12_실습1 extends JFrame {
	
	int width;
	int height;
	
	JPanel panel1;
	JPanel panel2;
	
	String[] title = {"RED", "GREEN", "BLUE"};
	Color[] color = {Color.RED, Color.GREEN, Color.BLUE};
	
	public week12_실습1() {
		this("20000 홍길동");
	}
	
	public week12_실습1(String title) {
		super(title);
		Toolkit kit = Toolkit.getDefaultToolkit(); //툴킷 객체 획득
		Image img = kit.getImage("img/char1.png"); //그림의 경로 
		this.setIconImage(img);
		this.width = kit.getScreenSize().width; //전체 화면의 폭 획득
		this.height = kit.getScreenSize().height; //전체 화면의 높이 획득
		this.setSize(this.width/2, this.height/2);
		this.setLocationRelativeTo(null); //창의 위치 설정 null 값 넣으면 화면 중앙에 뜬다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init(); //init 호출함
		this.setVisible(true);
	}

	public void init() {
		// TODO Auto-generated method stub
		panel1 = new JPanel(new GridLayout(1, 3, 5, 5));
		panel1.setBackground(Color.CYAN);
		panel2 = new JPanel();
		panel2.setBackground(Color.GREEN);
		
		for(int i = 0; i<title.length; i++) {
			JButton btn = new JButton(title[i]);
			final int idx = i;
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					panel2.setBackground(color[idx]);
					
				}		
			});
			panel1.add(btn);
		}
		
		
//		JButton btn1 = new JButton("RED");
//		btn1.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				panel2.setBackground(Color.RED);
//			}
//			
//		});		//버튼에 이벤트 처리하기 (AcitonListener는 익명 객체로 설정)
//			
//		JButton btn2 = new JButton("GREEN");
//		btn2.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				panel2.setBackground(Color.GREEN);
//			}
//			
//		});
//		
//		JButton btn3 = new JButton("BLUE");
//		btn3.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				panel2.setBackground(Color.BLUE);
//			}
//			
//		});
//		
//		panel1.add(btn1);
//		panel1.add(btn2);
//		panel1.add(btn3);
		
		Container frame = this.getContentPane();
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MyFrame frame = new MyFrame("홍길동");
		new week12_실습1("홍길동");
	}

}