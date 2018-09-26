package text;

import java.util.UUID;

public class UUID0 {
	public static void main(String[] args) {
		UUID uud = UUID.randomUUID();
		System.out.println(uud.toString());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {}
		System.out.println(uud.toString());
		System.out.println(UUID.randomUUID().toString());
	}
}
