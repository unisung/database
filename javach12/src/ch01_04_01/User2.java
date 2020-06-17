package ch01_04_01;

public class User2 extends Thread {
   //공유객체
  private Calculator calculator;
	
  public void setCalculator(Calculator calculator) {
		this.setName("User2");//thread명 설정
		this.calculator = calculator;
   }

	@Override
	public void run() {
		calculator.setMemory(50);
	}

}
