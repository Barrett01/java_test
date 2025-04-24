package fileIO.writer;
//写入 字符流FileWriter
import java.io.FileWriter;
import java.io.IOException;

public class FieWriter_ {
    public static void main(String[] args) {
         String fileName = "D://text//FieWriter.txt";
         FileWriter fw = null;

         int len ;
         char[] ch = {'a', 'b', 'c'};

        try {
            fw = new FileWriter(fileName);
//            write(int):写入单个字符,write（string）：写入整个字符串
//            fw.write("28257");
           // 4) write(char[]):写入指定数组
            fw.write (ch);
            //write(string,off,len):写入字符串的指定部分
//            fw.write("jsdfiwjhoepfgi wef",0,8);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
//                    fw.flush();
                    fw.close(); //flush+关闭
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
