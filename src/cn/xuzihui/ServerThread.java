package cn.xuzihui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 服务器线程处理类
 * @author Administrator
 *
 */
public class ServerThread extends Thread{
	//和本线程相关的Socket
	Socket socket = null;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	//线程执行的操作，响应客户端请求
	public void run() {
		//获取输入流，并读取客户端信息
		InputStream is = null;//字节输入流
		InputStreamReader isr = null;//将字节流转换为字符流
		BufferedReader br = null;
		//获取输出流，响应客户端的请求
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("我是服务器，客户端说:" + info);
			}
			socket.shutdownInput();//关闭输入流
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("欢迎您！");
			pw.flush(); //调用flush()方法将缓冲输出
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
				//关闭资源
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
