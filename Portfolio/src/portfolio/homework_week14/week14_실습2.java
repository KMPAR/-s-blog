package portfolio.homework_week14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class week14_실습2 extends JFrame implements ActionListener{
	Container frame = this.getContentPane();
	JLabel label = new JLabel();
	
	week14_실습2(String title){
		super(title);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null); //창의 위치 설정 null 값 넣으면 화면 중앙에 뜬다
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init(); //init 호출함
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		frame.add(label); //위치 지정 안해서 BorderLayout Center에 배정됨 ! > 전체크기 다 차지 중 !
		initMenu();
	}

	private void initMenu() {
		// TODO Auto-generated method stub
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("다이얼로그");
		JMenuItem item1 = new JMenuItem("파일선택");
		JMenuItem item2 = new JMenuItem("색상선택");
		menu.add(item1);		
		menu.add(item2);
		mb.add(menu);
		this.setJMenuBar(mb); //frame에 붙이기 !
		
		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//여기에서 this는 안에서 생성해준 객체 ! > MyFrame.this를 써야 자기자신을 나타내는 것 !!
				JFileChooser filechooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG","jpg");
				filechooser.setFileFilter(filter);
				int result = filechooser.showOpenDialog(week14_실습2.this);
				if(result == JFileChooser.APPROVE_OPTION) {
					String path = filechooser.getSelectedFile().getPath();
//					System.out.println(path);
					label.setIcon(new ImageIcon(path));
					pack();
				}
			}
		});
		
		item2.addActionListener(e->{
			//여기에서 this는 자기자신을 나타내는 객체임 ! > MyFrame.this 안써도 됨 !!
			Color result = JColorChooser.showDialog(this, "색상선택", Color.GREEN	); // 객체 생성 안하고 바로 호출해줘도 됨 ! > static 함수로 만들어졌기 때문 !
//			JColorChooser colorchooser = new JColorChooser();
//			Color result = colorchooser.showDialog(this, "색상선택",	Color.GREEN);
			if(result != null) {
				label.setOpaque(true); //불투명하게 설정해준다 ! > 원래 label은 투명색이라 color 값이 설정되지 않음 !
				label.setBackground(result);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new week14_실습2("202211415 박규민");
	}

	@Override
	public void actionPerformed(ActionEvent e) {  //맨 위에서 ActionListener를 참조시킴 !
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand(); // 공통으로 이벤트를 설정해줄 때 !! > 어떤 객체가 이벤트를 발생시켰나 ?
		switch(cmd) {
		case "파일선택": 
		case "색상선택":
		}
	}

}
