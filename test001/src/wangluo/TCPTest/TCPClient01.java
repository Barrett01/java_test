package wangluo.TCPTest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient01 {
    public static void main(String[] args) throws IOException {
        //本机 发送888端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 888);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("hello，我们又见面了");
        bw.close();
        socket.close();
        System.out.println("客户端退出");

    }
}
