package wangluo.homeworkwl.wlHomeWork01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/*
(1)使用字符流的方式,编写一个客户端程序和服务器端程序，
(2)客户端发送“name"服务器端接收到后，返回“我是nova ", nova是你自己的名字.
(3)客户端发送"hobby"，服务器端接收到后，返回“编写java程序”
(4)不是这两个问题，回复“你说啥呢"
问题:目前，我们只能问一次，就退出了，怎么可以问多次?->while ->聊天
 */
public class wlHomeWork01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket Serversocket = new ServerSocket(8080);//服务端的端口号为8080
        Socket socket = Serversocket.accept();//等待链接
       while (true) {
           BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           String s = buf.readLine();
           BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
           System.out.println(s);
           if ("name".equals(s)){
               writer.write("我是nova");
           }else if ("hobby".equals(s)){
               writer.write("编写java程序");
           } else if ("exit".equals(s)) {
               writer.close();
               buf.close();
               break;
           } else {
               writer.write("你说啥呢");
           }
           writer.newLine();
           writer.flush();


       }
        socket.close();


        Serversocket.close();


    }
}
