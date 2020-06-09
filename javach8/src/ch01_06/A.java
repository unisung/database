package ch01_06;

public class A {
  int field1;
  static int field2;
  void method1() {}
  static void method2() {}
  
  static class C{//static맴버로 선언된 클래스 내부에서 바깥쪽 맴버에 접근시
	  void method() {
		  //field1=2;//인스턴스맴버는 접근불가
		  field2=10;//static맴버는 접급가능
		  //method1();
		  method2();
	  }
  }
}
