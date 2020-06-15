package ch02;

import java.util.ArrayList;
import java.util.List;

//index로 객체를 관리하는 객체 List인터페이스
public class ListExample2 {
	public static void main(String[] args) {
	 List<String> list = new ArrayList<String>();
	 
	 //추가
	 list.add("홍길동");
	 list.add("일지매");//중복저장
	 list.add("임꺽정");
	 list.add("일지매");//중복저장
	 list.add("임꺽정");//중복저장
	 
	 //저장된 객체수 size()
	 System.out.println(list.size());
	 
	 //삽입 add(index,객체)
	 list.add(1,"이순신");
	 
	 //객체 얻기 get(index번호) 0부터 시작
	 for(int i=0;i<list.size();i++)
		 System.out.println(list.get(i));
	 
	 System.out.println("----------------");
	 //수정 set(index,객체)
	 list.set(2, "김길동");
	 for(int i=0;i<list.size();i++)
		 System.out.println(list.get(i));
	 
	 //해당객체가 list에 저장되어있는지 확인 list.constains(객체)
	 System.out.println(list.contains("이순신")?"list에 있습니다.":"list에 없습니다");
	 
	 //특정 index의 객체 삭제 remove(index)
	 System.out.println(list.remove(3));
	 
	 //특정 객체를 list에 삭제 remove(객체) 삭제여부 리턴
	 //중복저장된 객체는 모두 삭제
	 System.out.println(list.remove("임꺽정"));
	 System.out.println("------------------");
	 //삭제후 조회
	 for(int i=0;i<list.size();i++)
		 System.out.println(list.get(i));
	 
	 //list가 비어있는지 확인 isEmpty();
	 System.out.println(list.isEmpty());
	 
	 //전체 삭제 clear()모든 요소 삭제
	 list.clear();
	 
	 System.out.println(list.isEmpty());
	 
	 //toArray()리턴타입 Object[] 
	 Object[] strarray=list.toArray();
	 for(int i=0;i<strarray.length;i++)
		 System.out.println(strarray[i]);
	 
	 //입력시 오류
	 //java.lang.IndexOutOfBoundsException
	 //입력범위를 벗어난 index값으로 객체 저장시 오류발생
	 //list.add(7,"강길동");
	 
	 //범위를 벗어난 삭제 오류
	 //java.lang.IndexOutOfBoundsException
	 //list.remove(7);
	 
	 
	 
	 

	}
}
