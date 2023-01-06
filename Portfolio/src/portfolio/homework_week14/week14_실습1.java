package portfolio.homework_week14;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class week14_실습1 extends JFrame {
	Container frame = this.getContentPane();
	JTextField tf = new JTextField(10);
	JButton btn = new JButton("modalDlg");
	JButton btn2 = new JButton("modalessDlg");
	
	MyDialog2 dlg = null; //modaless dialog
	
	week14_실습1(String title){
		super(title);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null); //창의 위치 설정 null 값 넣으면 화면 중앙에 뜬다
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init(); //init 호출함
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		frame.setLayout(new FlowLayout());
		frame.add(tf);
		frame.add(btn);
		
		btn.addActionListener(e->{
			MyDialog dlg = new MyDialog(week14_실습1.this, "모달대화상자", true);
			String str = dlg.tf.getText();
			if(str.length() != 0) {
				tf.setText(str);
			}else {
				JOptionPane.showMessageDialog(null, "텍스트를 입력하지 않았습니다."); //오류 시 메세지 창이 뜸 ! > 모달 대화 상자임 ㅋ
			}
		}); //람다 표현식 !
		
//		btn.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
		
		frame.add(btn2);
		btn2.addActionListener(e->{
			if(dlg == null) //이러면 다이얼로그 하나만 생성됨 ! > 중복 생성 방지
				dlg = new MyDialog2(week14_실습1.this, "모달리스대화상자", false); //버튼 누를 때마다 다이얼로그 1개씩 계속 생성됨 !
			else {
				dlg.requestFocus(); //포커스를 다이얼로그로 옮겨주겠다 !
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 new week14_실습1("202211415 박규민");

	}

}
