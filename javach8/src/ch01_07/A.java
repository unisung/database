package ch01_07;

public class A {
  void method(int arg) {//final int arg로 인식
	  int localVariable =1;//로컬클래스에서 사용되는 변수는 상수.final int 로 인식 
	  //localVariable = 10;
	  //arg=10;
	  class Inner{
		   void method() {
			   int result =arg+localVariable;
		   }
	  }
  }
}