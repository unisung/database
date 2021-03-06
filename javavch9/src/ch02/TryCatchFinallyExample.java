package ch02;

public class TryCatchFinallyExample {
	public static void main(String[] args) {
		try {
			   String data=null;
			   data="hello";//문자열로 값 대입
			   System.out.println(data.length());
			   System.out.println(data.toString());
			   System.out.println("여기까지 실행");
		} catch (Exception e) {
			//예외 처리부분
			 System.out.println(e.getMessage());
		}finally {
			//
			System.out.println("종료시 예외발생과 상관없이 반드시 처리해야하는부분");
		}
	}
}
