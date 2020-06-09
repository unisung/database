package ch02_01;

public class ButtonExample {
	public static void main(String[] args) {
		Button btn=new Button();
		
		//구현체인 CallListener가 OnClickLister타입으로 프로모션되어 대입
		//매개변수의 다형성
		btn.setOnClickListener(new CallListener());
		btn.touch();//구현체의 재정의된 메소드 실행
		//구현체인 MessageListenerrk OnclickListener타입으로 프로모션되어 대입
		//매개변수의 다형성
		btn.setOnClickListener(new MessageListener());
		btn.touch();//구현체의 재정의된 메소드 실행
	}
}