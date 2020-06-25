package ch02;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FromCollectionExample {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
			 new Student("홍길동",10),
			 new Student("일지매",20),
			 new Student("임꺽정",30)
				);
		//콜렉션으로 부터 스트림 얻기(내부반복자)
		Stream<Student> stream = studentList.parallelStream();
		stream.forEach(t-> System.out.println(t.getName()));
		//외부 반복자
		Iterator<Student> iterator = studentList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
	}
}
class Student{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
}