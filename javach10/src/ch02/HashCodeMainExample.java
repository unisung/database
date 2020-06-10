package ch02;

public class HashCodeMainExample {
	public static void main(String[] args) {
	  Student s1 = new Student(1,"홍길동");
	  Student s2 = new Student(1,"홍길동");
	  
      System.out.println(s1.hashCode());
      System.out.println(s2.hashCode());
      
	  System.out.println(s1==s2);
	  System.out.println(s1.equals(s2));
	}
}
class Student extends Object{
	int sno;
	String name;
    //생성자
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
	@Override
	public int hashCode() {
		return sno;//리턴값 기본타입인 int
	}
	@Override
	public boolean equals(Object obj) {
		return sno==((Student)obj).sno;//비교대상이 기본타입 int
	}
}