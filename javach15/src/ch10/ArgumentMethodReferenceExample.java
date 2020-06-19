package ch10;

import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferenceExample {
	public static void main(String[] args) {
		ToIntBiFunction<String, String> function;
		
		function = new ToIntBiFunction<String, String>() {
			@Override
			public int applyAsInt(String t, String u) {
				return t.compareToIgnoreCase(u);
			}
		};
		
		print(function.applyAsInt("Java8","JAVA8"));

		function = String::compareToIgnoreCase;
		print(function.applyAsInt("java8","Java8"));
		
		
		
	}//main()
	public static void print(int order) {
		if(order<0) System.out.println("사전순으로 먼저 옵니다.");
		else if(order==0)System.out.println("동일한 문자열입니다.");
		else System.out.println("사전순으로 나중에 옵니다.");
	}
}
