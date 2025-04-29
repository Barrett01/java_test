package wangluo.TCPTest;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPServer01 {

    public static void main(String[] args) throws IOException {
        //本机端口888监听
        ServerSocket serverSocket = new ServerSocket(888);
        //等待链接
        Socket accept = serverSocket.accept();
        //读取内容
//        byte[] buffer = new byte[1024];
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String s = br.readLine();
        System.out.println("服务端端接收：");
        System.out.println(s);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("萧瑟秋风今又是，换了人间");
        bw.newLine();  //设置结束标志

        bw.flush();//刷新写入数据


        bw.close();
        br.close();
        accept.close();
        serverSocket.close();

    }
}
