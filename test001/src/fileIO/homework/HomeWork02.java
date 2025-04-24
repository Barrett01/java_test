package fileIO.homework;

import java.io.*;

/*
使用BufferedReader读取一个文本文件，为每行加上行号，再连同内容一并输出到屏幕上。
//如果把文件的编码改成了 gbk，出现中文乱码，大家思考如何解决
//1.默认是按照utf-8处理,开始没有乱码
//2.提示:使用我们的转换流，将FilelnputStream -> InputStreamReader[可以指定编码]- >BufferedReader ...
 */
public class HomeWork02 {
    public static void main(String[] args) throws IOException {
    String filePath = "D:\\text\\c.txt";
    String len;
    int linNum = 0;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "gbk"));
//        String s = bufferedReader.readLine();
//        System.out.println(s);
        while ((len = bufferedReader.readLine()) != null) {
            System.out.println(++linNum+":\t" +len);
        }
        bufferedReader.close();

    }
}
