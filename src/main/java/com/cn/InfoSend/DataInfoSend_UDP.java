package com.cn.InfoSend;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.apache.log4j.Logger;


public class DataInfoSend_UDP {
	
	private static final Logger logger = Logger.getLogger(DataInfoSend_UDP.class); 
	
	public static void main(String[] args) throws IOException {
		DataInfoSend_UDP dataInfoSend = new DataInfoSend_UDP();
		String dataJson = "d";
		/*dataInfoSend.DataInfoSend(dataJson);*/
    }
	
	
	public void DataInfoSend(String dataJson) throws IOException  {
		
		//要发送的数据
		//为空不执行
		if(dataJson.isEmpty()){
			logger.info("传入数据为空，不执行ubp传输");
			return ;
		}
		logger.info("开始进行udp传输");
		
		String host="101.37.23.220";
		int port=22060;
		int oneselfPort=9999;
		
		logger.info("来自"+oneselfPort+"端口发送。"+"----    目标IP地址："+host+"      目标端口地址："+port);
		
		//得到目标机器的地址实例
		InetAddress target = InetAddress.getByName(host);
		
		//从9999端口发送数据报
		DatagramSocket ds = new DatagramSocket(oneselfPort);
		
		//将数据转换成Byte类型
		byte[] buf = dataJson.getBytes("utf-8");
		
		// 把信息打包 new DatagramPacket(发送的字节数组, 数组中要出去多少字节, 对方的ip地址, 对方的端口号);
        // 注意：数据报的长度不能超过 64K
		//将BUF缓冲区中的数据打包
		DatagramPacket op = new DatagramPacket(buf, buf.length, target, port);
		
		/*op.setData(buf);
		op.setLength(buf.length);*/
		
		logger.info("开始发送"+op.toString());
		//发送数据
		ds.send(op);
		
		ds.close();
		logger.info("关闭udp发送对象");
	}
	
	
	

}
