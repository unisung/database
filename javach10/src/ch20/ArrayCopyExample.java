package ch20;

import java.util.Arrays;

public class ArrayCopyExample {
	public static void main(String[] args) {
		char[] arr1 = {'j','a','v','a'};
		
		//복사1
		char[] arr2 = Arrays.copyOf(arr1, arr1.length);
		//배열 문자열출력  Arrays.toString(배열)
		System.out.println(Arrays.toString(arr2));
		
		//복사2
		char[] arr3 = Arrays.copyOfRange(arr1, 1, 3);// 1<=범위<3
		System.out.println(Arrays.toString(arr3));
		
		//복사3
		char[] arr4 = new char[arr1.length];
		//arraycopy(원본배열,시작index,타겟배열,시작index,복사길이)
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
        System.out.println(Arrays.toString(arr4));
        
	}
}
