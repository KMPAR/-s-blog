package portfolio.homework_week05;

public class SalesReport {
	
	private Salesman[] team;
	private double highestSales;
	private double averageSales;
	private int number;
	
	public SalesReport(int num) {
		this.number = num;
		this.team = new Salesman[this.number];
		for(int i = 0; i<num; i++) {
			System.out.println(i+1 + "번째 팀원 정보 입력");
			Salesman Team = new Salesman();
			Team.readInput();
			this.team[i] = Team;
			System.out.println("입력완료");
		}
	}
	
	public void computStats() {
		double num = 0;
		for(Salesman Team : this.team) {
			if(Team.getSales()>num)
				num = Team.getSales();
		}
		this.highestSales = num;
		
		double sum = 0;
		for(int i = 0; i<team.length; i++) {
			sum += team[i].getSales();
		}
		this.averageSales = sum / this.number;
	}
	
	public Salesman getBestClerk() {
		Salesman bestMember = null;
		
		if(number!=0) {
			double best = 0 ;
			for(Salesman Team : this.team) {
				if(Team.getSales() > best) {
					best =Team.getSales();
					bestMember = Team;
				}
			}
		}
		return bestMember;
	}	

	@Override
	public String toString() {
		String str = "총 팀원 수: "+this.number;
		str += "\n최고판매액: "+this.highestSales;
		str += "\n평균판매액: "+this.averageSales;
		str += "\n-------------------------------\n";
		for(Salesman Team : this.team) {
			str += "이름: "+Team.getName()+" / 실적: "+Team.getSales()+"\n";
		}
		return str;
	}	
}
