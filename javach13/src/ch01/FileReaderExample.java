package ch01;

import java.io.FileNotFoundException;
import java.io.FileReader;

//문자단위 입력 Reader -FileReader
public class FileReaderExample {
 public static void main(String[] args){
  try(FileReader reader = new FileReader("c:\\tmp\\test.txt");){
	  int c;
	  while((c=reader.read())!=-1) {//reader.read() 리턴 타입 정수, 입력된값의 아스키코드값
		    System.out.print((char)c);
	  }
	}catch(Exception e) {}
 }
}
