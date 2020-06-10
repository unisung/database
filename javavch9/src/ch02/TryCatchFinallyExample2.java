package ch02;

public class TryCatchFinallyExample2 {
	public static void main(String[] args) {
		try {
			   String data=null;
			   //data="hello";//문자열로 값 대입
			   System.out.println(data.length());//이부분에서 예외발생하여 catch절로 이동
			   System.out.println(data.toString());//이부분 실행안됨
			   System.out.println("여기까지 실행");//이부분 실해안됨
		} catch (Exception e) {
			//예외 처리부분
			 System.out.println("예외메세지:"+e.getMessage());
		}finally {
			//이부분 실행됨.
			System.out.println("종료시 예외발생과 상관없이 반드시 처리해야하는부분");
		}
	}
}
