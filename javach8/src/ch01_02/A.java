package ch01_02;
//static맴버로 선언된 내부클래스
public class A {
	static class B{//static맴버
		B(){}
		int field1;//인스턴스맴버
		static int field2;//static맴버
		void method1() {}//인스턴스맴버
		static void method2() {}//statci맴버
	}
}
