package ch08;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
	 Queue<Message> messageQue = new LinkedList<>();
	 //queue에 객체 저장 offer(객체)
	  messageQue.offer(new Message("sendMail", "홍길동"));
	  messageQue.offer(new Message("sndSMS","일지매"));
	  messageQue.offer(new Message("sendKaTok","임꺽정"));
	  //객체 꺼낼째 poll();
	  while(!messageQue.isEmpty()) {
		  Message message = messageQue.poll();//제일앞의 객체 얻기
		  switch (message.command) {
		case "sendMail":
			    System.out.println(message.to+"님에게 메일 전송");
			break;
         case "sndSMS":
			    System.out.println(message.to+"님에게 SMS 전송");
			break;
         case "sendKaTok":
 			   System.out.println(message.to+"님에게 카톡전송");
 			break;	
		}
	  }
	}
}
class Message{
	public String command;
	public String to;
	
	public Message(String command, String to) {
		this.command = command;
		this.to = to;
	}
	
}