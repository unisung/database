package ch21;

public class VauleCompareExample {
	public static void main(String[] args) {
		System.out.println("[-128~127 초과 인경우]");
		Integer obj1=300;//boxing
		Integer obj2=300;//boxing
		
		System.out.println("결과:"+(obj1==obj2));
		System.out.println("결과:"+(obj1.intValue()==obj2.intValue()));
		System.out.println("결과:"+(obj1.equals(obj2)));
		
		System.out.println("[-128~127 범위 인경우]");
		obj1=10;//boxing
		obj2=10;//boxing
		
		System.out.println("결과:"+(obj1==obj2));
		System.out.println("결과:"+(obj1.intValue()==obj2.intValue()));
		System.out.println("결과:"+(obj1.equals(obj2)));

	}

}
