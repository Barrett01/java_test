package wangluo.TCPTestFile;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
客户端
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8568);//客户端链接向本地8586端口发送数据
        String filename = "D://text/xiamu.jpg";//图片地址。图片使二进制，需要使用字节流
//        不用这种方式，这种方式太难操作
//        byte[] data = new byte[1024];
//        int len = 0;
//        //如果文件不存在？，暂时忽略这一情况
//        FileInputStream fileInputStream = new FileInputStream(filename);
//        fileInputStream.read(data);
//        while ((len = fileInputStream.read(data)) != -1) {
//
//            OutputStream outputStream = socket.getOutputStream();
//            outputStream.write(data, 0, len);
//        }
//        fileInputStream.close();
//        socket.close();
        //创建读取输出流读取磁盘文件
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(filename));
        byte[] bytes = StreamUtils.streamToByteArray(bin);//拿到图片的二进制字符

        //创建输出流 到服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bos.flush();//刷新把数据传过去
        socket.shutdownOutput(); //设置写入数据的结束标记

        //接收服务端消息
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);


        //关闭流
        inputStream.close();
        bos.close();
        bin.close();
        socket.close();


    }
}
