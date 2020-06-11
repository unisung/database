package ch17;

public interface Action {
 public void execute();
}
class SendAction implements Action{
	@Override
	public void execute() {
     System.out.println("데이타를 보냅니다.");
	}
}
class ReceiveAction implements Action{
	@Override
	public void execute() {
		System.out.println("데이타를 받습니다.");		
	}
}
