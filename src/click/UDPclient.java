package click;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPclient {
	public static void main(String[] args) throws IOException {
		DatagramSocket client = new DatagramSocket(9001);
		byte msg[] = new byte [1024];
		DatagramPacket pack = new DatagramPacket(msg, 0,msg.length);
		System.out.println("等待接收消息");
		client.receive(pack);
		System.out.println("收到：" + new String(msg,0,pack.getLength()));
		client.close();
	}
}
