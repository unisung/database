package ch05;

public class Counter {
	private int no;

	public Counter(int no) {
		this.no = no;
	}

	@Override
	protected void finalize() throws Throwable {
     System.out.println(no+"번 객쳉의 finaliize()가 실행됨");
	}

}
