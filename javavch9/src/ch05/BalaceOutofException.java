package ch05;

public class BalaceOutofException extends Exception {
	public BalaceOutofException() {
        this("잔고가부족합니다.");
	}

	public BalaceOutofException(String message) {
		super(message);
	}
}