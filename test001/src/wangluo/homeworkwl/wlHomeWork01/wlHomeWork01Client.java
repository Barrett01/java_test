package wangluo.homeworkwl.wlHomeWork01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
(1)使用字符流的方式,编写一个客户端程序和服务器端程序，
(2)客户端发送“name"服务器端接收到后，返回“我是nova ", nova是你自己的名字.
(3)客户端发送"hobby"，服务器端接收到后，返回“编写java程序”
(4)不是这两个问题，回复“你说啥呢"
问题:目前，我们只能问一次，就退出了，怎么可以问多次?->while ->聊天
 */
public class wlHomeWork01Client {
    public static void main(String[] args) throws IOException {
        //链接“本地”网络地址，8080端口；
        Socket socket = new Socket(InetAddress.getByName("192.168.0.108"), 8080);

        while (true){
            //输出流
            BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //监听键盘输入
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入向客户端发送的信息：");
            String next = scanner.next();

            bwr.write(next);
            bwr.newLine();//结束语
            bwr.flush();
            //接收来自服务端的消息回复
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = reader.readLine();
            System.out.println(s);
            if (next.equals("exit")){
                reader.close();
                bwr.close();
                break;
            }

        }







        socket.close();


    }
}
