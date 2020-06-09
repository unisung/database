package ch01_02;

public class AMainExample {
	public static void main(String[] args) {
	  //static맴버  객체 생성
		A.B b = new A.B();
	  b.field1=3;//인스턴스 맴버에 접근
	  b.field2=3;//static맴버에 접근
	  b.method1();//인스턴스 맴버에 접근
	  b.method2();//static맴버에 접근
	}
}
