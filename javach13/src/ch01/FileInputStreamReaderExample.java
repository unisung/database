package ch01;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileInputStreamReaderExample {
	public static void main(String[] args) {
		try(FileInputStream fi=new FileInputStream("c:\\tmp\\hangul.txt");
			InputStreamReader is=new InputStreamReader(fi, "UTF-8");	
	       ){
			  int c;
			  while((c=is.read())!=-1){
				     System.out.print((char)c);
			  }
		}catch(Exception e) {}
	}

}
