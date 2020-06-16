package ch07;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

public class DescendingComparatorExample {
	public static void main(String[] args) {
	TreeSet<Fruit> treeSet 
	    = new TreeSet<Fruit>(new DescendingComparator());
	treeSet.add(new Fruit("포도", 3000));
	treeSet.add(new Fruit("수박",10000));
	treeSet.add(new Fruit("딸기",6000));
	Iterator<Fruit> itor = treeSet.iterator();
	while(itor.hasNext()) {
		Fruit f = itor.next();
		System.out.println(f.name+","+f.price);
	}
	}
}
class DescendingComparator implements Comparator<Fruit>{
	@Override
	public int compare(Fruit o1, Fruit o2) {
		return -(Objects.hash(o1.price)-Objects.hash(o2.price));
	}
}
class Fruit{
	String name;
	int price;
	public Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}
}