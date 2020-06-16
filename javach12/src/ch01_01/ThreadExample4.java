package ch01_01;

public class ThreadExample4 {
	public static void main(String[] args) {
		//생성 실행
		Thread th = new Thread(new SumThread2());//생성자의 매개변수 Runnable로 Promotion
        th.start();
	}
}
//Runnable인터페이스를 구현한
//SumThread2클래스 새성
//1~100까지의 값을 sum하는 작업 중간에 0.1초씩 멈췄다가 진행하도록 선언 
class SumThread2 implements Runnable {
	@Override
	public void run() {//thread로 실행할 내용
		int sum=0;
		for(int i=1;i<=100;i++) {
			sum+=i;
			System.out.println(sum);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
		System.out.println("종료");
	}
}
