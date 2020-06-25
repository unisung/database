package ch02;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArraysExample {
	static int sum=0;
	public static void main(String[] args) {
	 String[] strArray = {"홍길동","일지매","임꺽정"};
	 //배열로부터 스트림 얻기 Arrays.stream(배열)
	 Stream<String> strSteam = Arrays.stream(strArray);
	 strSteam.forEach(s->System.out.println(s));

	 int[] intArray= {1,2,3,4,5};
	 //정수배열로부터 스트림 얻기 IntStream 변수=Arrays.stream(배열)
	 IntStream intStream = Arrays.stream(intArray);
	 intStream.forEach(s->System.out.println(s+","));
	 
	 //숫자범위로 부터 스트림 얻기
	//람다식이 메소드내(로컬로)선언되었을때 메소드내에서 선언된 변수를
	 //람다식에서 사용하는 경우 선언된 변수는 상수가 됨.
	 //변수를 로컬이 아닌 클래스맴버로 선언
	 IntStream stream = IntStream.rangeClosed(1, 100);//1~100
	 stream.forEach(v-> sum+=v);
	 System.out.println("총합:"+sum);
	 
	}
}
