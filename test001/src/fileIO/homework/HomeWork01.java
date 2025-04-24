package fileIO.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *(1) 在判断 e 盘下是否有文件夹mytemp ,如果没有就创建mytemp
 *(2) 在e:\\mytemp 目录下, 创建文件 hello.txt
 *(3) 如果hello.txt 已经存在，提示该文件已经存在，就不要再重复创建了
 *(4) 并且在hello.txt 文件中，写入 hello,world~
 */
public class HomeWork01 {
    public static void main(String[] args) throws IOException {
        String  fileName = "D:\\text\\mytemp";
        String filePath = "D:\\text\\mytemp\\hello.txt";

        File file = new File(fileName);
        if (!(file.exists())) {
            if (file.mkdir()){
                System.out.println("创建成功");
            }else {
                System.out.println("创建失败");
            }
        }

        file = new File(filePath);
        if (!(file.exists())) {
            if (file.createNewFile()){
                System.out.println("创建成功");
            }else {
                System.out.println("创建失败");
            }
        }else {
            System.out.println("该文件已经存在，无需创建");
        }
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("hello,word02 ~");
        bufferedWriter.close();

    }
}
