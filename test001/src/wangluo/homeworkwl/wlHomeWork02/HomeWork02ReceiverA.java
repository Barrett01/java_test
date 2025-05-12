package wangluo.homeworkwl.wlHomeWork02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
接收端
(1)编写一个接收端A,和一个发送端B,使用UDP协议完成
(2)接收端在8888端口等待接收数据(receive)
(3)发送端向接收端发送数据“四大名著是哪些”
(4)接收端接收到发送端发送的问题后，返回“四大名著是<<红楼梦>>.…."，否则返回what?
(5)接收端和发送端程序退出
 */
public class HomeWork02ReceiverA {
    public static void main(String[] args) throws IOException {
        String name ="";
        DatagramSocket socket = new DatagramSocket(8888);//8888端口监听

        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);//接收
        //拆包 打印
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
        if ("四大名著是哪些？".equals(s)) {
            name = "四大名著是<<红楼梦>>.….";
        }else {
            name = "what??";
        }
        data = name.getBytes();
        DatagramPacket packet1 = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.0.108"), 8889);
        socket.send(packet1);
        socket.close();
        System.out.println("A端退出~");


    }
}
