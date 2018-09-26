package click;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client0 {
	private static  final BufferedReader KEYBOARD_VALUE  = new BufferedReader(new InputStreamReader(System.in)); 
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",9000);
		Scanner scan = new Scanner(client.getInputStream());
		scan.useDelimiter("\n");
		PrintStream out = new PrintStream(client.getOutputStream());
		boolean flag = true;

		while(flag) {
			String input = getString("请输入数据: ").trim();
			out.println(input);
			if(scan.hasNext()) {
				System.out.println(scan.next());
				if("bye".equals(input)) {
					out.close();
					scan.close();
					flag = false;					
				}

			}
			}
		
	}
	public static String getString(String str) throws IOException {
		System.out.println(str);
		String in = KEYBOARD_VALUE.readLine();
		return in;
	}
}
