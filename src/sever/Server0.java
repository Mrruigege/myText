package sever;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0 {
	private static class ClientThread implements Runnable{
		private Socket  client =  null;
		private Scanner scan = null;
		private PrintStream out = null;
		boolean flag = true;
		public ClientThread(Socket client) throws IOException {
			this.client = client;
			this.scan =new Scanner( client.getInputStream());
			this.out = new PrintStream(client.getOutputStream());
		}
		@Override
		public void run() {
			while(flag) {
				if(scan.hasNext()) {
					String val = scan.next().trim();
					if("bye".equals(val)) {
						scan.close();
						out.close();
					}else {
						out.println("echo " + val);
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9000);
		System.out.println("等待用户连接。。。。。");
		boolean flag = true;
		while(flag) {
			Socket client = server.accept();
			new	Thread(new ClientThread(client)).start();
		}
	}
}
