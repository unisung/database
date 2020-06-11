package ch03;

import java.util.Scanner;

//try-with-resources
public class TryCatchWithResourcesExample {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
	        String message = scanner.next();
			System.out.println(message);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}//finally{ scanner.close();} <-이부분이 필요없음.
	}
}