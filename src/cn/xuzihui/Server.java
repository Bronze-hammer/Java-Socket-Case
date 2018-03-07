package cn.xuzihui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���¼
 * ��������
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			//1.����һ����������Socket����ServerSocket��ָ���󶨵Ķ˿ڣ��������˶˿�
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			//2.����accept()������ʼ�������ȴ��ͻ��˵�����
			System.out.println("***�����������������ȴ��ͻ��˵�����***");
			//ѭ�������ȴ��ͻ��˵�����
			while(true) {
				//����accept()������ʼ�������ȴ��ͻ��˵�����
				socket = serverSocket.accept();
				//����һ���µ��߳�
				ServerThread serverThread = new ServerThread(socket);
				//�����߳�
				serverThread.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
