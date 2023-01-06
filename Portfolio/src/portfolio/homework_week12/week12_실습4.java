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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class week12_실습4 extends JFrame {
	
	
	JPanel panel1, panel2;
	Container frame = this.getContentPane();
	//레이블에 이미지 부착 !
	JLabel imgChar = new JLabel();
	ImageIcon img = new ImageIcon("img/char1.png"); //툴킷 말고 이미지 아이콘으로 이미지 불러오기 가능!
	int xpos=100, ypos=100;
	
	public week12_실습4() {
		this("200000 홍길동");
	}
	
	public week12_실습4(String title) {
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
				if(xpos >= 10) { //이미지가 화면 밖으로 나가지 않도록 제어 구문 추가 !
					xpos-=10;
					imgChar.setBounds(xpos, ypos, img.getIconWidth(), img.getIconHeight()); //왼쪽으로 이동 !
				}
				
		}});
		JButton btn2 = new JButton("Home");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xpos=100;
				ypos=100;
				imgChar.setBounds(xpos, ypos, img.getIconWidth(), img.getIconHeight());
			}
			
		});
		JButton btn3 = new JButton(">>");
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(xpos <= (panel2.getWidth()-img.getIconWidth()-10)) //이미지 포지션은 맨 왼쪽을 기준으로 함 !
				xpos+=10; 
				imgChar.setBounds(xpos, ypos, img.getIconWidth(), img.getIconHeight()); //오른쪽으로 이동 !
			}
			
		}); 
		
		panel1.add(btn1);
		panel1.add(btn2);
		panel1.add(btn3);
		
		frame.add(panel1, BorderLayout.NORTH);
		
	}
	
	private void initPanel2() {
		// TODO Auto-generated method stub
		this.panel2 = new JPanel(); //패널의 디폴트는 플로우레이아웃이고 센터로 지정됨 . 자동 정렬되므로 위치가 바뀌지 않음 ! > 레이아웃 매니저 삭제해야함 !
		panel2.setLayout(null); //레이아웃 매니저 객체가 없어짐 !
		imgChar.setIcon(img); //레이블에 이미지에 해당하는 정보가 아이콘으로 들어감 !
		imgChar.setOpaque(true);
		imgChar.setBackground(Color.CYAN);
		imgChar.setBounds(xpos, ypos, img.getIconWidth(), img.getIconHeight()); //이미지 위치 크기 결정 !
		panel2.add(imgChar);
		frame.add(panel2, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new week12_실습4("20000 홍길동");

	}

}