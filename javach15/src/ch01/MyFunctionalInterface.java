package ch01;

@FunctionalInterface//인터페이스가 추상메소드를 하나만 가지고있는지 확인하는 역활
//람다식으로 사용되는 인터페이스는 추상메소드가 하나만 있어야함.
public interface MyFunctionalInterface {
	public void method();//추상메소드
	//public void method2();
}
