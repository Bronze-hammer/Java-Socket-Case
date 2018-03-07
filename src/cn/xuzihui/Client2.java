package cn.xuzihui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���¼
 * �ͻ���
 * @author Administrator
 *
 */
public class Client2 {
	public static void main(String[] args) {
		try {
			//1.�����ͻ���Socket��ָ����������ַ�Ͷ˿�
			Socket socket = new Socket("localhost", 8888);
			//2.��ȡ���������������˷�����Ϣ
			OutputStream os = socket.getOutputStream();//�ֽ������
			PrintWriter pw = new PrintWriter(os);//���������װΪ��ӡ��
			pw.write("�û���:admin_2;����:456");
			pw.flush();
			socket.shutdownOutput(); //�ر������
			
			//3.��ȡ����������ȡ�������˵���Ӧ��Ϣ
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info = br.readLine())!=null) {
				System.out.println("���ǿͻ���2��������˵��"+info);
			}
			
			//4.�ر���Դ
			br.close();
			is.close();
			
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}