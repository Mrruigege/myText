package text;
//此时程序运行时错误，需要引入Comparable接口才可以比较
import java.util.Arrays;
class Person{
	private String name;
	private int age;
	public Person(String name, int age) {
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
	
}
public class Sort0 {
	public static void main(String[] args) {
		Person per[] = new Person[] {
			new Person("xiaominga",10),
			new Person("xiaomingb",12),
			new Person("xiaomingc",9)
		};
		Integer date[] = new Integer[] {1,20,6,3,8};
		String str[] = new String[] {"a","x","b","h"};
		Arrays.sort(str);
		Arrays.sort(date);
		Arrays.sort(per);
		System.out.println(Arrays.toString(per));
		System.out.println(Arrays.toString(date));
		System.out.println(Arrays.toString(str));
	}
}
