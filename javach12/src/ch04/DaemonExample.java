package ch04;

public class DaemonExample {
	public static void main(String[] args) {
		//Thread객체 생성
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		//start()실행전에 설정
		autoSaveThread.setDaemon(true);
		System.out.println("메인 쓰레드 시작");
		//실행요청
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		}catch(Exception e) {}
		System.out.println("메인 쓰레드 종료");
	}
}
