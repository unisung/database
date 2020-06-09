package ch01_08;

public class Outter {
	//바깥클래스의맴버
	String field="Outer-field";
	void method() {
		System.out.println("Outter-method");
	}
	
	class Nested{
		String field = "Nested-field";
		void method() {
			System.out.println("Nested-method");
		}
		void print() {
			System.out.println(this.field);//내부클래스의 필드
			this.method();//내부클래스의 메소드
			
			System.out.println(Outter.this.field);//외부클래스이 필드
			Outter.this.method();//외부클래스의 메소드
		}
	}
}
