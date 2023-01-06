package portfolio.homework_week14;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

//모달 다이얼로
@SuppressWarnings("serial")
public class MyDialog extends JDialog {
	Container dialog = this.getContentPane();
	JTextField tf = new JTextField(10);
	JButton btn = new JButton("OK");

	public MyDialog(week14_실습1 parent, String title, boolean modal) {
		super(parent, title, modal);
		// TODO Auto-generated constructor stub
		this.setSize(500, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //EXIT 하면 프로그램 전체가 종료됨 !!
		this.setLocationRelativeTo(null);
		init();
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		dialog.setLayout(new FlowLayout());
		dialog.add(tf);
		dialog.add(btn);
		
		btn.addActionListener(e->{
			dispose(); //dispose 호출하면 창을 종료할 수 있음 !!
		});
	}

}
