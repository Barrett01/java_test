package wangluo.TCPTestFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



/*
服务端
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8568);//服务端在本机8568端口监听
        Socket socket = serverSocket.accept();//等待链接

        //接收客户端发来的图片
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //把接受的图片复制到对应的路径
        String destFilePath = "java_test/test001/src/xiamu.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.flush();//刷新

        BufferedOutputStream bos2 = new BufferedOutputStream(socket.getOutputStream());
        bos2.write("我已收到图片".getBytes());
//        BufferedWriter bos2 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        bos2.write("我已收到图片");
        bos2.flush();
        socket.shutdownOutput();


        bos2.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();



    }
}
