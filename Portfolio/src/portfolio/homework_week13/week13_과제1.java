package portfolio.homework_week13;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class week13_과제1 extends JFrame implements ItemListener {
	Container frame = this.getContentPane();
	String[] data = {"배", "사과", "포도"};
	ButtonGroup g = new ButtonGroup();
	JRadioButton rb[] = new JRadioButton[3];
	JLabel[] labels = new JLabel[3];
	
	JPanel panel1, panel2;
	
	week13_과제1(String title){
		super(title);
		this.setSize(500,500); //필수 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //필수 
		this.setLocationRelativeTo(null); //화면 중앙으로 옮기기 !
		init();
		this.setVisible(true); //필수 
	}

	private void init() {
		// TODO Auto-generated method stub
		initPanel1();
		initPanel2();
		
	}

	private void initPanel1() {
		// TODO 체크박스 만들어서 붙이기
		panel1 = new JPanel();
		for(int i =0 ; i<data.length; i++) {
			rb[i] = new JRadioButton(data[i]);
			rb[i].addItemListener(this); //현 클래스에 만들었기 때문에 this로 받은 것 !! 내부 클래스로 구현할 경우 내부클래스 이름 넣으면 됨 !
			g.add(rb[i]); 
			panel1.add(rb[i]);
		}
		frame.add(panel1, BorderLayout.NORTH);
	}

	private void initPanel2() {
		// TODO 레이블 만들기
		panel2 = new JPanel();
		for(int i =0 ; i<data.length; i++) {
			labels[i] = new JLabel(data[i]);
//			labels[i].setVisible(false); //화면에서 감춰짐 !
//			panel2.add(labels[i]);
		}
		frame.add(panel2, BorderLayout.CENTER);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) { //이벤트를 만들고 꼭 달아줘야 함 !!!!!
		// TODO Auto-generated method stub
		int idx = -1;
		for(int i=0; i<data.length; i++) {
			if(e.getSource()==rb[i]) {
				idx=i; //이벤트를 발생시킨 객체의 위치값을 찾음 !
				break; 
			}
		}
		
		//동적으로 add 할 때는 화면에 자동으로 그려지지 않음 > 화면에 다시 그려주는 작업을 해야 함 !!
		if(idx>=0) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				panel2.add(labels[idx]);
			}else {
				panel2.remove(labels[idx]);
			}
			panel2.revalidate(); //배치관리자에게 레이아웃 변경되었음을 알려줌 !
			panel2.repaint(); //화면에 다시 그려줘 !
		}
	
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new week13_과제1("202211415 박규민");

	}
}
