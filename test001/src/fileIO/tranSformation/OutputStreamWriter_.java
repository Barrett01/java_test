package fileIO.tranSformation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath  = "D:\\text\\c.txt";
        String charSet = "gbk";

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath),charSet);
        outputStreamWriter.write("十分吻合覅哦十五分");
        outputStreamWriter.close();

    }
}
