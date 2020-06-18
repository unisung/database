package ch02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {
	public static void main(String[] args) {
		BufferedReader in=null;//입력스트림
		BufferedWriter out=null;//출력스트림
		ServerSocket listener=null;//소켓생성하는 서버소켓
		Socket socket=null;//실제 통신을 담당하는 소켓
		Scanner scanner = new Scanner(System.in);

		try {
			listener = new ServerSocket(9999);//서버소켓 생성
			System.out.println("연결을 기다리고 있습니다.");
			socket=listener.accept();//클라이언트 연결시 소켓 생성
			System.out.println("연결되었습니다.");
			//통신 작업 시작
in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//데이타 전송
while(true) {
	 String inputMessage = in.readLine();//한줄 단위로 읽기
	 if(inputMessage.equalsIgnoreCase("bye")) {
		  System.out.println("클라이언트에서 bye로 연결을 종료하였습니다.");
		  break;
	 }
	 System.out.println("클라이언트:"+inputMessage);
	 System.out.println("보내기>>");
	 String outputMessage = scanner.nextLine();//키보드로부터 입력받기
	 if(outputMessage.equalsIgnoreCase("bye")) {
			out.write(outputMessage+"\n");//서버로 종료메세지 보내고
			out.flush();//버퍼비우기
			break;//종료
		}
	 out.write(outputMessage+"\n");//한줄 단위로 읽도록 전달
     out.flush();//메모리 데이타 밀어내기
}

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
			scanner.close();
			socket.close();
			listener.close();
			}catch(Exception e) {System.out.println("오류");}
		}
	}
}
