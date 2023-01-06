package portfolio.homework_week14;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class week14_실습3 extends JFrame {
	Container frame = this.getContentPane();
	JPanel panel;
	JButton btn;
	DefaultTableModel model;
	JTable table;
	String[] title = {"아이디", "비밀번호", "이름"};	
	MyDialog3 dlg = null;
	
	week14_실습3(String title){
		super(title);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null); //창의 위치 설정 null 값 넣으면 화면 중앙에 뜬다
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init(); //init 호출함
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		this.panel = new JPanel();
		this.btn = new JButton("정보입력");
		btn.addActionListener(e->{
			if(dlg == null)
				dlg = new MyDialog3(week14_실습3.this, "정보입력", false);
			else 
				dlg.requestFocus();
		});
		
		this.model = new DefaultTableModel(title, 0);
		this.table = new JTable(model);
//		this.model.addColumn(title);
		this.panel.add(btn);
		
		frame.add(panel, BorderLayout.NORTH);
		frame.add(new JScrollPane(table), BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new week14_실습3("202211415 박규민");

	}

}
