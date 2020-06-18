package ch02;

public class Lambda2Example {
	public static void main(String[] args) {
		//익명객체 선언
		MyFunctionalInterface mf = new MyFunctionalInterface() {
			@Override
			public void methid(int x) {
			  	System.out.println(x*x);
			}
		};
		   mf.methid(10);
		   
       //람다식
		mf = x->System.out.println(x*x);
		
		mf.methid(4);
		
		   
	}

}
