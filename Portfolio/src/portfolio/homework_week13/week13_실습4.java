package portfolio.homework_week13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class week13_실습4 extends JFrame implements ActionListener{
	Container frame = this.getContentPane();
	String[] color = {"Red", "Green", "Blue"};
	
	week13_실습4(String title){
		super(title);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null); //창의 위치 설정 null 값 넣으면 화면 중앙에 뜬다
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init(); //init 호출함
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		initMenu();
		initToolBar();
	}
	
	private void initToolBar() {
		// TODO Auto-generated method stub
		JToolBar toolbar = new JToolBar("Color");
		for(int i=0; i<color.length; i++) {
			JButton btn = new JButton(color[i]); //메뉴 구성과 같은 이름으로 버튼 추가 ! > 버튼에 별도의 액션커맨드를 하지 않으면 버튼의 캡션 값으로 액션커맨드를 함 !
			btn.addActionListener(this);
			toolbar.add(btn);
		}
		JButton btn = new JButton(new ImageIcon("img/char1.png"));
		btn.setActionCommand("Green"); //이미지 버튼을 누르면 이벤트 처리한 곳에서는 그린으로 받는다 !
		btn.addActionListener(this);
		toolbar.add(btn);
		this.add(toolbar, BorderLayout.PAGE_START); //NORTH 위 영역이 PAGE_START ! //보통 메뉴로 구성했던 것들로 툴바를 구성함 > 이벤트처리 안해줘도 기능함 !
	}

	private void initMenu() {
		// TODO Auto-generated method stub
		JMenuBar menubar = new JMenuBar();
		JMenu colorMenu = new JMenu("색상");
		for(String str : color) {
			JMenuItem menu = new JMenuItem(str);
			menu.addActionListener(this);
			colorMenu.add(menu);
		}
		menubar.add(colorMenu);
		
		JMenu Menu = new JMenu("기타색상");
		Menu.add(new JMenuItem("노란색"));
		
		colorMenu.add(Menu); //메뉴에 메뉴를 추가시키면 서브 메뉴가 됨 !!
		
		menubar.add(colorMenu);
		
		this.setJMenuBar(menubar); //실제 프레임에 메뉴바를 부착 !
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String menu = e.getActionCommand();
		switch(menu) {
		case "Red": frame.setBackground(Color.RED); break;
		case "Blue": frame.setBackground(Color.BLUE); break;
		case "Green": frame.setBackground(Color.GREEN); break;
		case "노란색": frame.setBackground(Color.YELLOW); break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new week13_실습4("20000 홍길동");
	}
}
