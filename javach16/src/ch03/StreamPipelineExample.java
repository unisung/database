package ch03;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipelineExample {
	public static void main(String[] args) {
     List<Member> list = Arrays.asList(
    		new Member("홍길동",Member.MALE,30),
    		new Member("일지매",Member.FEMALE,20),
    		new Member("임꺽정",Member.MALE,45),
    		new Member("홍길순",Member.FEMALE,27)
    		 );		
     
     double ageAvg = list.stream()
    		         .filter(t->t.getGender()==Member.MALE)
    		         .mapToInt(t->t.getAge()).average().getAsDouble();
    	System.out.println("남자 평균 나이: "+ageAvg);	 
		/*
		 * Stream<Member> maleStream = list.stream(); maleStream.filter(new
		 * Predicate<Member>() {
		 * 
		 * @Override public boolean test(Member t) { return t.getGender()==Member.MALE;
		 * } });
		 * 
		 * IntStream ageStream = maleStream.mapToInt(new ToIntFunction<Member>() {
		 * 
		 * @Override public int applyAsInt(Member member) { return member.getAge(); }
		 * });
		 * 
		 * OptionalDouble optionalDouble = ageStream.average(); double average =
		 * optionalDouble.getAsDouble();
		 * 
		 * 
		 * }
		 */
 }
}
class Member{
	public static int MALE=0;
	public static int FEMALE=1;
	
	private String name;
	private int gender;
	private int age;
	
	public Member(String name, int gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public int getGender() {		return gender;	}

	public int getAge() {		return age;	}
	
	
	
	
}