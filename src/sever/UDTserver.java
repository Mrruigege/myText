package sever;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDTserver {
	public static void main(String[] args) throws IOException {
		DatagramSocket server = new DatagramSocket(9000);
		String str = "hello world";
		DatagramPacket  pack = new DatagramPacket(str.getBytes(), 0, str.length(),InetAddress.getByName("localhost"),9001);
		server.send(pack);
		System.out.println("消息发送完成");
		server.close();
	}
}
