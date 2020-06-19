package ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class UrlExample2 {
	public static void main(String[] args) throws IOException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("소스를 보고싶은 url주소는?");
	String str=scanner.nextLine();
	//URL정보 객체 생성
	URL url = new URL(str);
	//해당 URL연결
	URLConnection uc = url.openConnection();//url접속하기
	//입력스트림얻기 getInputStream();
	InputStream is = uc.getInputStream();//입력스트림객체 얻기
	InputStreamReader isr=new InputStreamReader(is,"utf-8");
	BufferedReader br = new BufferedReader(isr);
	String data="";
	//읽어들인 정보 출력
	while((data=br.readLine())!=null) {
		System.out.println(data);
	}
	is.close();
	isr.close();
	br.close();
	}
}
