package ch01_04;

public class A {
	//인스턴스필드
	B field1 = new B();
	C field2 = new C();
	
	//인스턴스 메소드
	void method1() {
		B var1 = new B();
		C var2 = new C();
	}
	//static 필드 초기화
	//static B field3=new B();//B가 인스턴스 맴버 이므로 static 불가
	static C field4=new C();//C가 static이므로 가능
	
	//static메소드 
	static void method2() {
		//B var1 = new B();//B가 인스턴스 맴버 이므로 static메소드에 올수 없음
		C var2=new C();//C가 static이므로 가능
	}
	//인스턴스 맴버 -중첩
	class B{}
	//static맴버-중첩
	static class C{}
}
