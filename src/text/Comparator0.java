package text;

import java.util.Arrays;
import java.util.Comparator;

class Person1{
	private String name;
	private int age;
	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "姓名 ： " + this.name + "、年龄： "  + this.age + "\n";
	}
}
class PersonComparator implements Comparator<Person1>{
	@Override
	public int compare(Person1 p1, Person1 p2) {
		return p1.getAge() - p2.getAge();
	}
}
public class Comparator0 {
	public static void main(String[] args) {
		Person1 per[] = new Person1[] {
				new Person1("x",10),
				new Person1("y",32),
				new Person1("xx",4)
		};
		Arrays.sort(per, new PersonComparator());
		System.out.println(Arrays.toString(per));
	}
}
