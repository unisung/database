package ch01;

import java.util.Arrays;
import java.util.List;
public class MapAndReduceExample {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("홍길동",10),
				new Student("신용권",20),
				new Student("유미선",30)
				);
		//메소드 chaining 
		double avg = studentList.stream()
				                .mapToInt(v-> v.getScore())
				                .average()//평균산출 메소드
				                .getAsDouble();
        System.out.println("평균 점수:"+avg);		
		

	}

}
