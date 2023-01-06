package portfolio.homework_week02;

public class week02_과제2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202211415 박규민");

		int rgb = 0x88a5ff73;
		String strRgb = Integer.toBinaryString(rgb);
		System.out.println("현재 색상 : " + strRgb);
		
		String strRgb_front = strRgb.substring(0, 16);
		String strRgb_behind = strRgb.substring(strRgb.length()-8);
		
		String a = "00000000";
		String strRgb_result = strRgb_front + a + strRgb_behind;
		
		System.out.println("변경 색상 : " + strRgb_result);

	}

}
