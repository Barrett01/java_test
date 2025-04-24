package fileIO.tranSformation;

import java.io.*;

public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
       String filePath = "D:\\text\\a.txt";
       int len;

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath) ,"gbk");
        while ((len = inputStreamReader.read()) != -1) {
            System.out.print((char) len);
        }
        //希望用BufferedReader读取
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        String s = bufferedReader.readLine();
//        System.out.println(s);


        inputStreamReader.close();


    }
}
