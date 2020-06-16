package ch01_05;

public class TargetThread extends Thread {
	@Override
	public void run() {
		for(long i=0;i<10000000;i++) {}
		
		try {
			Thread.sleep(1500);//1.5초가 멈춤
		}catch(Exception e) {}
		
		for(long i=0;i<10000000;i++) {}
	}
}
