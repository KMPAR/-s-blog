package portfolio.homework_week13;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class week13_실습3 extends JFrame implements ActionListener, ItemListener{
	Container frame = this.getContentPane();
	JPanel panel1;
	String[] fname = {"바탕체", "돋움체", "굴림체", "궁서체", "Helvetica"};
	Integer[] fsize = {10, 12, 14, 16, 18, 20, 22, 24};
	DefaultComboBoxModel<String> fontNameModel = new DefaultComboBoxModel<>(fname);
	DefaultComboBoxModel<Integer> fontSizeModel = new DefaultComboBoxModel<>(fsize); //콤보박스의 구성요소를 추가시킬 수 있음 !! .add 해주면 됨!
	JComboBox<String> fontname;
	JComboBox<Integer> fontsize;
	JCheckBox fsbold, fsitalic;
	JTextField str;
	JLabel labelstr;
	
	String name = "바탕체";
	int size = 12;
	boolean bold = false;
	boolean italic = false;
	Font font = new Font(name, Font.PLAIN, size);
	
	week13_실습3(String title){
		super(title);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null); //창의 위치 설정 null 값 넣으면 화면 중앙에 뜬다
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init(); //init 호출함
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		panel1 = new JPanel();
		fontname = new JComboBox<>(fontNameModel);
		fontsize = new JComboBox<>(fontSizeModel);
		fontsize.setSelectedIndex(1);
		fsbold = new JCheckBox("Bold");
		fsitalic = new JCheckBox("Italic");
		str = new JTextField(15);
		
		panel1.add(fontname);
		panel1.add(fontsize);
		panel1.add(fsbold);		
		panel1.add(fsitalic);
		panel1.add(str);
		
		frame.add(panel1, BorderLayout.NORTH);
		
		labelstr = new JLabel("202211415 박규민", SwingConstants.CENTER);
		labelstr.setFont(font);
		frame.add(labelstr, BorderLayout.CENTER);
		
		initListener();
		
		fontSizeModel.addElement(26);
	}

	private void initListener() {
		// TODO Auto-generated method stub
		this.fontname.addActionListener(this);
		this.fontsize.addActionListener(this);
		this.fsbold.addItemListener(this);
		this.fsitalic.addItemListener(this);
		this.str.addActionListener(e -> {
			labelstr.setText(str.getText());
			str.setText("");
		}); //간단한 거라서 람다 표현식으로 구현 !!
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == fsbold) { //이벤트를 발생시킨 곳이 fsbold 인가?
			if(e.getStateChange() == ItemEvent.SELECTED) { //체크박스가 체크되었다면 ...
				bold = true;
			}else {
				bold = false;
			}
		}else if(e.getSource() == fsitalic) { //이벤트를 발생시킨 곳이 fsltalic 인가?
			if(e.getStateChange() == ItemEvent.SELECTED) { //체크박스가 체크되었다면 ...
				italic= true;
			}else {
				italic = false;
			}
		}
		showNewFont();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == fontname) { //이벤트 발생시킨 곳이 fontname 인가 ?
			name = fname[fontname.getSelectedIndex()]; 
		}else if(e.getSource() == fontsize) { //이벤트 발생시킨 곳이 fontsize 인가 ?
			//size = fsize[fontsize.getSelectedIndex()]; //fsize로 접근하면, 추가한 26이 실행이 안됨 ! > 배열에 추가한거라서 !
			size = (Integer)fontsize.getSelectedItem(); 
		}
		showNewFont();
	}
	
	private void showNewFont() {
		// TODO 폰트 새로 만들기 함수 > 폰트 객체를 다시 만들어주자 !
		if(bold && italic) {
			font = new Font(name, Font.BOLD|Font.ITALIC, size);
		}else if(bold == true && italic == false) {
			font = new Font(name, Font.BOLD, size);
		}else if(bold == false && italic == true) {
			font = new Font(name, Font.ITALIC, size);
		}else {
			font = new Font(name, Font.PLAIN, size);
		}
		labelstr.setFont(font);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new week13_실습3("200000 홍길동");

	}

}
