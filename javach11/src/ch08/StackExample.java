package ch08;

import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<Coin>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		while(!coinBox.isEmpty()) {
			System.out.println(coinBox.peek().getValue());//삭제않고 보여주기 peek()
			Coin coin = coinBox.pop();//꺼내기 메소드 pop();
			System.out.println("꺼내온 동전:"+coin.getValue()+"원");
		}
	}
}
class Coin{
 private int value;

public Coin(int value) {
	this.value = value;
}

public int getValue() {
	return value;
}
}