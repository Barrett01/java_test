package fileIO;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
输出流：写入文件
 */
public class FileOutputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void writeFile01() {
        String path = "D:\\text\\news01.txt";
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream =  new FileOutputStream(path,true);//默认覆盖，true追加
//            fileOutputStream.write('E');//加入字节
            String str = "hh hello!";
            fileOutputStream.write(str.getBytes(),0,str.length());//可以加入字符串；off是从初始位置 写几个字符{len}进去
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("插入成功");
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
