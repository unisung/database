package ch03_01;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample3 {
	public static void main(String[] args) {
	  List<Member> list=Arrays.asList(
			  new Member("홍길동",Member.MALE,30),
			  new Member("일지매",Member.FEMALE,20),
			  new Member("임꺽정",Member.MALE,45),
			  new Member("김길동",Member.FEMALE,27)
			  );
	  
	 //내부반복자를 이용한 처리 
	 Stream<Member> maleFemaleStrem=list.stream();
	   maleFemaleStrem.forEach(t->t.getGender());
	   
	 Stream<Member> maleStream
	     = maleFemaleStrem.filter(t->t.getGender()==Member.MALE);
	    
	  maleStream.forEach(t->System.out.println(t.getAge()));
	 
	 IntStream ageStream=
	 maleStream.mapToInt(member->member.getAge());
	 
	OptionalDouble optionalDouble=ageStream.average();
	double ageAvg=optionalDouble.getAsDouble();
	System.out.println("평균:"+ageAvg);

	}
}
