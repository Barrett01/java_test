package fileIO.buffered;

import java.io.*;
//使用处理流实现字符的拷贝BufferedReader
public class BufferedCopy_ {
    public static void main(String[] args) {
        //是按照字符去操作的，不要去操作二进制文件【图片 音频 pdf word等】，{如果操作可能会报错，造成文件损坏}
        String filePath = "D:\\text\\a.txt";
        String fileCopy = "D:\\text\\b.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String len;

        try {
            br = new BufferedReader(new FileReader(filePath));
            bw  = new BufferedWriter(new FileWriter(fileCopy));
            while ((len = br.readLine())!=null){
                bw.write(len);
                bw.newLine();
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
                System.out.println("copy成功~");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
