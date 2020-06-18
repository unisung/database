package ch02;

public class Lambda3Example {
	public static void main(String[] args) {
		MyFunctionalInterface mf
		  = i->System.out.println(i+10);
		mf.methid(20);

	}
}
