package fileIO.reader;
//字符流FileRead 的练习
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {

    }
    @Test
    public void readFiletest() {
        String filePath = "D:\\text\\story.txt";
        FileReader fr = null;

        int readLen = 0;
        char[] buf = new char[1024];

        try {
            fr = new FileReader(filePath);
            while ((readLen = fr.read(buf)) != -1){
                System.out.println(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fr != null) {
                    fr.close();
                }
//                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
