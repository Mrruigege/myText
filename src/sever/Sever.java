package sever;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Sever {
	private static class ClientServer implements Runnable{
		private Socket client = null;
		private Scanner scan = null;
		private PrintStream out = null;
		boolean flag = true;
		public ClientServer(Socket client) throws IOException {
			this.client = client;
			this.scan = new Scanner(this.client.getInputStream());
			scan.useDelimiter("\n");
			this.out = new PrintStream(this.client.getOutputStream());
		}
		@Override
		public void run() {
			while(this.flag) {
				if(scan.hasNext()) {
					String val = scan.next().trim();
					if("byebye".equals(val)) {
						flag = false;
					}else {
						out.println("【echo】" + val);
					}
				}
		}
			try {
				scan.close();
				out.close();
				client.close();
			}catch(IOException e) {
				e.printStackTrace();};
			}
	}
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9999);
		System.out.println("等待用户连接....");
		boolean flag = true;
		while(flag) {
			Socket client = server.accept();
			new Thread( new ClientServer(client)).start();
		}
		
		
	}
}
