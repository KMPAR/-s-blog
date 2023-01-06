package portfolio.homework_week14;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//모달 다이얼로
@SuppressWarnings("serial")
public class MyDialog3 extends JDialog {
	Container dialog = this.getContentPane();
	
	JTextField uid = new JTextField(10);
	JPasswordField upassword = new JPasswordField(10);
	JTextField uname = new JTextField(10);
	JButton ok = new JButton("확인");
	JButton cancel = new JButton("취소");
	week14_실습3 parent;

	public MyDialog3(week14_실습3 parent, String title, boolean modal) {
		super(parent, title, modal);
		// TODO Auto-generated constructor stub
		this.parent = parent;
		this.setSize(300, 300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //EXIT 하면 프로그램 전체가 종료됨 !!
		this.setLocationRelativeTo(null);
		init();
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		dialog.setLayout(new GridLayout(4, 2));
		dialog.add(new JLabel("아이디"));
		dialog.add(uid);
		dialog.add(new JLabel("비밀번호"));
		dialog.add(upassword);
		upassword.setEchoChar('*'); //입력하면 별표시가 화면에 뜸 !
		dialog.add(new JLabel("이름"));
		dialog.add(uname);
		dialog.add(ok);
		dialog.add(cancel);
		
		ok.addActionListener(e->{
			String uId = this.uid.getText();
			if(uId.length() > 0) {
				String[] data = {parent.dlg.uid.getText(), 
						new String(upassword.getPassword()),
						uname.getText()};
				parent.model.addRow(data);
			}else {
				JOptionPane.showMessageDialog(null, "입력필드가 비었음.");
			}
			parent.dlg = null;
			dispose();
		});
		
		cancel.addActionListener(e->{
			uid.setText("");
			upassword.setText("");
			uname.setText("");
			parent.dlg = null;
			dispose();
		});
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) { //OK버튼 말고 X를 눌러 종료해도 위와 똑같이 실행되도록 함 !
				// TODO Auto-generated method stub
				super.windowClosing(e);
				parent.dlg = null; 
				dispose();
			}		
		});
	}
}
