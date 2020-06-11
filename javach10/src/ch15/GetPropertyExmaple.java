package ch15;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExmaple {
	public static void main(String[] args) {
		String osName=System.getProperty("os.name");
		String useName=System.getProperty("user.name");
		String userHome=System.getProperty("user.home");
		
		System.out.println("운영체제:"+osName);
		System.out.println("사용자:"+useName);
		System.out.println("홈디렉토리:"+userHome);
		
		//getProperties()환경변수값을 출력메소드
		//키(문자열)=값(문자열)
		Properties prop =System.getProperties();
		//키=값 -Set
		Set keys = prop.keySet();
		//향상된 for문
		for(Object objKey:keys) {
			String key = (String)objKey;
			String value =System.getProperty(key);
			System.out.println("["+key+"="+value+"]");
		}
	}
}
