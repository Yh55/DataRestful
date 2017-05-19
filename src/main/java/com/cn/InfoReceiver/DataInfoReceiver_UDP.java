package com.cn.InfoReceiver;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DataInfoReceiver_UDP {
	public static void main(String[] args) throws IOException {
		DataInfoReceiver_UDP dataInfoReceiver = new DataInfoReceiver_UDP();
		dataInfoReceiver.DataInfoReceiver();
    }
	
	
	public void DataInfoReceiver() throws IOException{
		byte[] buf = new byte[1000];
		DatagramSocket ds = new DatagramSocket(12345);
		//开始监视12345端口
		DatagramPacket ip = new DatagramPacket(buf, buf.length);
		//创建接收数据报的实例
		while (true){
			ds.receive(ip);
			//阻塞，直到收到数据报后将数据装入IP中
			System.out.println(new String(buf));
		}
	}
	
	
}
