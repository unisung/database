package ch01_03;

public class MyStackExample {
	public static void main(String[] args) {
	 GStack<String> stringStack=new GStack<String>();
	 stringStack.push("seoul");
	 stringStack.push("busan");
	 stringStack.push("LA");
	 
	 System.out.println(stringStack.pop());//
	 System.out.println(stringStack.pop());
	 System.out.println(stringStack.pop());
	 
	 GStack<Integer> integerStack=new GStack<Integer>();
	 integerStack.push(1);//AutoBoxing
	 integerStack.push(3);
	 integerStack.push(5);
	 
	 System.out.println(integerStack.pop());//AutoUnBoxing
	 System.out.println(integerStack.pop());
	 System.out.println(integerStack.pop());
	}
}
class GStack<T>{
	int tos;
	Object []stck;
	public GStack() {
	tos=0;
	stck=new Object[10];
	}
	public void push(T item) {
		if(tos==10) return;
		stck[tos]=item;
		tos++;
	}
	public T pop() {
		if(tos==0) return null;
		tos--;
		return (T)stck[tos];//Object[]배열 ->T타입으로 casting후 리턴
	}
}
