package cn.xuzihui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * �������̴߳�����
 * @author Administrator
 *
 */
public class ServerThread extends Thread{
	//�ͱ��߳���ص�Socket
	Socket socket = null;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	//�߳�ִ�еĲ�������Ӧ�ͻ�������
	public void run() {
		//��ȡ������������ȡ�ͻ�����Ϣ
		InputStream is = null;//�ֽ�������
		InputStreamReader isr = null;//���ֽ���ת��Ϊ�ַ���
		BufferedReader br = null;
		//��ȡ���������Ӧ�ͻ��˵�����
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("���Ƿ��������ͻ���˵:" + info);
			}
			socket.shutdownInput();//�ر�������
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("��ӭ����");
			pw.flush(); //����flush()�������������
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
				//�ر���Դ
				if (pw != null)
					pw.close();
				if (os != null)
					os.close();
				if (br != null)
					br.close();
				if (isr != null)
					isr.close();
				if (is != null)
					is.close();
				if (socket != null)
					socket.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}
		
	}
}
