package ch02;

public class TryCatchFinallyExample5 {
	public static void main(String[] args) {
		try {
			   String data=null;
			   data="hello";//문자열로 값 대입
			   System.out.println(data.length());//이부분에서 예외발생하여 catch절로 이동
			   String[] strings = {"hello","hi"};
			   System.out.println(strings[1]);
			   double result = 5/0;
		}catch(NullPointerException | ArrayIndexOutOfBoundsException  e) { 
			System.out.println("null포인트나 배열인덱스 예외발생");
		}catch (Exception e) {
			//예외 처리부분
			 System.out.println("예외메세지:"+e.getMessage());
		}finally {
			//이부분 실행됨.
			System.out.println("종료시 예외발생과 상관없이 반드시 처리해야하는부분");
		}
	}
}
