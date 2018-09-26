package click;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		Socket client = new Socket("localhost",9999);
		Scanner scan = new Scanner(client.getInputStream());
		scan.useDelimiter("\n");
		PrintStream out = new PrintStream(client.getOutputStream());
		boolean flag  = true;
		while(flag) {
			String input = getString("请输入要发送的内容:").trim();
			out.println(input);
			if(scan.hasNext()) {	
				if(scan.hasNext()) {
					System.out.println(scan.next());
				}
				if("byebye".equals(input));
				flag = false;
			}
		}
		client.close();
	}
	public static String getString(String promt) throws Exception{
		System.out.println(promt);
	    String str = KEYBOARD_INPUT.readLine();
	    return str;
	}
}
