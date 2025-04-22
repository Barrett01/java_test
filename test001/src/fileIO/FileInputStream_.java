package fileIO;

import org.junit.jupiter.api.Test;
/*
演示FileInputStream的使用(字节输入流 文件--> 程序)
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void readFile01() {
        String filename = "D:\\text\\news03.txt";
        FileInputStream fis = null;
        int readData = 0;

        try {
            fis = new FileInputStream(filename);
            while ((readData = fis.read()) != -1){
                System.out.print((char)readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();//关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    public void readFile02() {
        String filename = "D:\\text\\news03.txt";
        FileInputStream fis = null;
        int readLen = 0;
        byte[] buf = new byte[8];

        try {
            fis = new FileInputStream(filename);
            while (( readLen = fis.read(buf))!= -1){
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
