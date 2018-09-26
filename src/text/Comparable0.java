package text;

import java.util.Arrays;

class Per implements Comparable<Per>{
	private String name;
	private int age;
	public Per(String name ,int age) {
		this.name = name ;
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
	public int compareTo(Per per) {
		return this.age - per.age;
	}
	@Override
	public String toString() {
		return "name : " + this.name + "、 age : " + this.age + "\n";
	}
}
public class Comparable0 {
	public static void main(String[] args) {
		Per per[] = new Per[] {
			new Per("aa",20),
			new Per("bb",10),
			new Per("cc",15)
		};
		Arrays.sort(per);
		System.out.println(Arrays.toString(per));
	}
}
