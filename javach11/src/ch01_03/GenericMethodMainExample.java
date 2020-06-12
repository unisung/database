package ch01_03;

public class GenericMethodMainExample {
	public static void main(String[] args) {
		//Double타입의 GStack생성
		GStack<Double> gs = new GStack<Double>();
		
		//5개의 요소를 스택에 push
		for(int i=0;i<5;i++)
			gs.push(new Double(i));//0,1,2,3,4
		
		//메소드 실행
		gs=GenericMehodExample.reverse(gs);//4,3,2,1,0
		
		//출력
		for(int i=0;i<5;i++)
			System.out.println(gs.pop());//0,1,2,3,4

	}

}
