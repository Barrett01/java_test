package fileIO.buffered;

import java.io.*;

//使用BufferedInputStream 和 BufferedOutputStream 复制图片{二进制}
public class BufferedCopy02_ {
    public static void main(String[] args) {
        String srcPath = "D:\\text\\xiamu.jpg";
        String destPath = "D:\\text\\xiamu_copy.jpg";

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis  =  new BufferedInputStream(new FileInputStream(srcPath));
            bos = new BufferedOutputStream(new FileOutputStream(destPath));
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1){
                bos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
                System.out.println("二进制图片复制成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
