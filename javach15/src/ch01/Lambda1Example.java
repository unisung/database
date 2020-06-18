package ch01;

public class Lambda1Example {
	public static void main(String[] args) {
		//구현체를 promotion하여 대입
		MyFunctionalInterface mf = new MyFunctionalInterface() {
			@Override
			public void method() {
            System.out.println("함수적인터페이스의 메소드");
			}
		};
		mf.method();
//람다식 메소드가 매개변수가 없는 형태이면 ()은 표시.
		mf =()-> System.out.println("함수적인페이스의 메소드");
		
	}
}
