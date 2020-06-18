package ch05;

public class ThisExample {
	public int outterField=10;
	
	class Inner{
		int innerField=20;
		
		void method() {
			//람다식
		 MyFunctionalInterface mf
		 =new MyFunctionalInterface() {
			 int innerField=10;
			@Override
			public void method() {
				System.out.println("OutterField:"+outterField);
				System.out.println("outterField:"+ThisExample.this.outterField+"\n");
				
				System.out.println("innerField:"+innerField);
				System.out.println("innerField:"+this.innerField+"\n");
			}
		};
		mf.method();
		}
	}

}
