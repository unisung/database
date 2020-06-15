package ch02_03;

import java.util.Vector;

public class VectorMainExample {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(7);//
		v.add("홍길동");
		v.add("일지매");
		v.add("임꺽정");
		v.add("일지매");//객체 중복 저장가능
		
		//저장된 갯수 size()
		System.out.println(v.size());
		//저장가능 공간
		System.out.println(v.capacity());//
		
		//중간삽입
		v.add(1,"이순신");
		
		//get(index)
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
		
		//elementAt(index)
		System.out.println(v.elementAt(1));//
		
		//저장되어있는지 여부확인 contains(객체)
		System.out.println(v.contains("이순신"));
		
		//삭제 remove(index) 삭제한 객체를 리턴
		System.out.println(v.remove(2));
		
		//삭제 remove(객체) true/false
		System.out.println(v.remove("임꺽정"));
		
		//전체 삭제
		v.clear();
		//비어있는지 여부확인
		System.out.println(v.isEmpty());
		
		v.add("java"); v.add("html"); v.add("css"); v.add("database");
		
		//백터요소들을 배열로 리턴
		Object[] objs = v.toArray();
		for(int i=0;i<objs.length;i++) {
			System.out.print(objs[i]+"\t");
		}
		System.out.println();
		//전체 삭제
		v.removeAllElements();//
		
		System.out.println(v.isEmpty());

	}
}
