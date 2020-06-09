package ch01_05;

public class A {
	int field1;
	static int field2;
	
	void method1() {}
	static void method2() {}
	
	class B{//인스턴스 맴버로 선언된 클래스에서는
		void method() {
		field1=2;//바깥쪽 인스턴스맴버
	    field2=10;//static맴버에 모두 접근 가능
	    method1();
	    method2();
		}
	}
}
