package portfolio.homework_week11;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StdComparator implements Comparator<Student>{
	int flag = 0;
	
	
	
	public StdComparator(int flag) {
		super();
		this.flag = flag;
	}

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		switch(this.flag) {
		case 1 : return (o1.score - o2.score)* -1;
		case 2 : return (o1.score - o2.score);
		case 3 : return o1.sname.compareTo(o2.sname);
		case 0 :
		default : return o1.sname.compareTo(o2.sname)* -1;
		}
		//return (o1.score - o2.score)* -1; //내림차순 //-1 없으면 오름차순
	}
}


public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", "2000", 52));
		list.add(new Student("김길동", "2011", 92));
		list.add(new Student("이길동", "2022", 82));
		list.add(new Student("고길동", "2009", 62));
		System.out.println(list);
		
		Stream<Student> stream = list.stream();
		//stream.sorted().forEach(std -> System.out.println(std)); //consumer 에 해당하는 인자
		//stream.sorted().forEach(System.out::println); //학번순
		//list.stream().sorted((o1, o2) -> (o1.score - o2.score)*-1).limit(2).forEach(System.out::println); //성적순
		List<Student> flist = list.stream().filter(std -> std.score >= 80).collect(Collectors.toList()); //80점 이상인 사람들 리스트로 만들어서 반환
		System.out.println(flist);
		
		int sum = list.stream().collect(Collectors.summingInt(Student::getScore)); //메소드 참조 사용해서 정수를 공급 받을 수 있음.
		System.out.println(sum);	
		
		double avg = list.stream().collect(Collectors.averagingInt(Student::getScore));
		System.out.println(avg);
		
		Collections.sort(list);
		System.out.println(list);
		int idx = Collections.binarySearch(list, new Student("", "2022", 0));
		if(idx >= 0)
			System.out.println(list.get(idx));
		else
			System.out.println("없음");
		
		//int compare(Student o1, Student o2)
		Collections.sort(list, (o1, o2) -> o1.sname.compareTo(o2.sname)); //람다 표현식 이름순으로 정렬
		//Collections.sort(list, new StdComparator(3));
		idx = Collections.binarySearch(list, new Student("김길동", "", 0), (o1, o2) -> o1.sname.compareTo(o2.sname));
		if(idx >= 0)
			System.out.println(list.get(idx));
		else
			System.out.println("없음");
		
		Collections.sort(list, (o1, o2) -> (o1.score - o2.score)* -1); //람다 표현식 내림차순으로 정렬
		
		
		//StdComparator cmp = new StdComparator();
		
		Collections.sort(list, new StdComparator(1));
		System.out.println(list);
		Collections.shuffle(list);
		Collections.sort(list, new StdComparator(3));
		System.out.println(list);
		
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.sid.compareTo(o2.sid);
			}
			
		});
		
		
		Predicate<Student> con = std -> std.score >= 80;
		for(Student s : list) {
			if(con.test(s))
				System.out.println(s);
		}
	}
}


