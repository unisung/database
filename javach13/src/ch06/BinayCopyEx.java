package ch06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BinayCopyEx {
	public static void main(String[] args) {
		//문자,이미지,동영상,사운드,...
		File src=new File("c:\\tmp\\srcImg.png");
		File dest=new File("c:\\tmp\\copyImg.png");
		long start = System.currentTimeMillis();
		int c;
		try(FileInputStream fi=new FileInputStream(src);
			FileOutputStream fo=new FileOutputStream(dest)){
			while((c=fi.read())!=-1){//[0][0][0][1]
				fo.write((byte)c);//byte단위 처리[0][0][0][1]
			}
		  System.out.println(src.getPath()+"를 "+dest.getPath()+"로 복사완료");
		  long end = System.currentTimeMillis();
		  System.out.println("작업시간:"+(end-start)); 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
