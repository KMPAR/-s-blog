package portfolio.homework_week14;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//모달리스 다이얼로그
@SuppressWarnings("serial")
public class MyDialog2 extends JDialog {
	Container dialog = this.getContentPane();
	JTextField tf = new JTextField(10);
	JButton btn = new JButton("OK");
	week14_실습1 parent = null; //나를 띄운 프레임 정보를 항상 접근할 수 있음 !

	public MyDialog2(week14_실습1 parent, String title, boolean modal) {
		super(parent, title, modal);
		// TODO Auto-generated constructor stub
		this.parent = parent;
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
			String str = tf.getText();
			if(str.length() != 0) {
				parent.tf.setText(str);
			}else {
				JOptionPane.showMessageDialog(null, "텍스트를 입력하지 않았습니다."); //오류 시 메세지 창이 뜸 !
			}
			parent.dlg = null; //OK 버튼 클릭 시 다이얼로그를 null로 바꾸어 다시 버튼을 눌렀을 때 다이얼로그가 생성될 수 있도록 함 > 이거 안하면 dlg 값이 남아 있어서 한번만 생성됨!
			dispose(); //dispose 호출하면 창을 종료할 수 있음 !!
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
