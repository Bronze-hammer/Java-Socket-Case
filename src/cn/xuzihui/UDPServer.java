package cn.xuzihui;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * �������ˣ�ʵ�ֻ���UDP���û���¼
 * @author Administrator
 *
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		//1.������������DatagramSocket��ָ���˿�
		DatagramSocket socket = new DatagramSocket(8800);
		//2.�������ݱ������ڽ��տͻ��˷��͵�����
		byte[] data = new byte[1024];//�����ֽ����飬ָ�����յ����ݱ���С
		DatagramPacket packet = new DatagramPacket(data, data.length);
		System.out.println("***�����������������ȴ��ͻ��˵�����***");
		//3.���տͻ��˷��͵�����
		socket.receive(packet);//�˷����ڽ��յ����ݱ�֮ǰ��һֱ����
		//4.��ȡ����
		String info = new String(data, 0, packet.getLength());
		System.out.println("���Ƿ��������ͻ���˵:"+info);
		
		//��ͻ�����Ӧ����
		//1.����ͻ��˵ĵ�ַ���˿ںš�����
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "��ӭ����".getBytes();
		//2.�������ݱ���������Ӧ����Ϣ
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
		//3.��Ӧ�ͻ���
		socket.send(packet2);
		//4/�ر���Դ
		socket.close();
		
	}
}
