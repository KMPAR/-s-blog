package portfolio.project_final;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;


@SuppressWarnings("serial")
public class FinalFrame extends JFrame {
	static Scanner scan = new Scanner(System.in);
	Container frame = this.getContentPane();
	JButton setsize = new JButton("빙고판 만들기");
	JButton putword = new JButton("입력");
	JTextField word = new JTextField(20);
	JLabel bingo = new JLabel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	public FinalFrame() {
		this("202211415 박규민");
	}
	
	public FinalFrame(String title) {
		super(title);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null); //창의 위치 설정 null 값 넣으면 화면 중앙에 뜬다
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init(); //init 호출함
		this.setVisible(true);
	}

	private void init() {
		
		MyDialog dialog = new MyDialog(this, "빙고 크기 입력");
		// TODO Auto-generated method stub
		setsize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dialog.setVisible(true);
				String text = dialog.getInput();
				int n = Integer.parseInt(text);
				panel2.setLayout(new GridLayout(n, n));
				JButton[] wordbtn = new JButton[n*n];
				for(int i = 0; i < n*n; i++) {
					wordbtn[i] = new JButton("1");
					panel2.add(wordbtn[i]);
				}
			}
			
		});
		
		panel1.add(setsize);
		panel1.add(word);
		panel1.add(putword);
		frame.add(panel1, BorderLayout.NORTH);
		panel2.setVisible(true);
		frame.add(panel2, BorderLayout.CENTER);
	}
	
	class MyDialog extends JDialog{
		JTextField tf = new JTextField(10);
		JButton okButton = new JButton("OK");
		public MyDialog(JFrame frame, String title) {
			super(frame,title, true); 
			setLayout(new FlowLayout()); 
			add(tf);
			add(okButton);
			setSize(200, 100);
			okButton.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				}
			});
		}
		String getInput() {
			if(tf.getText().length() == 0) return null;
			else return tf.getText();
			}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FinalFrame("202211415 박규민");
	}

}
