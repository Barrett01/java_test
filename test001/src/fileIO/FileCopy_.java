package fileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
文件的拷贝
 */
public class FileCopy_ {
    public static void main(String[] args) {

        String srcPath = "D:\\text\\test\\夏目背景.jpg";
        String newSrcPath = "D:\\text\\夏目背景.jpg";
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(newSrcPath);
            byte[] bytes = new byte[1024];//定义字节数组 提到读取速率
            int len;

            while ((len = fis.read(bytes)) != -1){
               fos.write(bytes,0,len);
            }
            System.out.println("拷贝成功~");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis != null){
                    fis.close();
                }
                if(fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
