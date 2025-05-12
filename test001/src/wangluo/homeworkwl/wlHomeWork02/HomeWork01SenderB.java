package wangluo.homeworkwl.wlHomeWork02;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/*
发送端
(1)编写一个接收端A,和一个发送端B,使用UDP协议完成
(2)接收端在8888端口等待接收数据(receive)
(3)发送端向接收端发送数据“四大名著是哪些”
(4)接收端接收到发送端发送的问题后，返回“四大名著是<<红楼梦>>.…."，否则返回what?
(5)接收端和发送端程序退出
 */
public class HomeWork01SenderB {
    public static void main(String[] args) throws IOException {
//        DatagramSocket socket = new DatagramSocket(8888, InetAddress.getByName("192.168.0.108"));错误实例
        DatagramSocket socket = new DatagramSocket(8889);//在8889端口监听
        //输入
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入你的问题：");
        String s = scanner.next();
        byte[] data = s.getBytes();
        //打包发送
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.0.108"), 8888);//在于DatagramPacket的两种用发，用于接收和发送
        socket.send(packet);

        byte[] buf = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(buf, buf.length);
        socket.receive(packet1);

        //拆包
        int length = packet1.getLength();
        byte[] data1 = packet1.getData();
        String s1 = new String(data1, 0, length);
        System.out.println(s1);

        socket.close();
        System.out.println("B端退出~");


    }
}
