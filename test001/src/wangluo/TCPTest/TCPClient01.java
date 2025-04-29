package wangluo.TCPTest;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient01 {
    public static void main(String[] args) throws IOException {
        //本机 发送888端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 888);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("hello，我们又见面了");
        bw.newLine();//插入一个换行符，表示写入的内容结束；对方一定要使用readLine（）接收；
       //需要手动刷新，否则不会写入数据通道
        bw.flush();


       BufferedReader br =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println(s);

        bw.close();
        br.close();
        socket.close();
        System.out.println("客户端退出");

    }
}
