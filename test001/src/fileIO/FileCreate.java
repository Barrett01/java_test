package fileIO;

import java.io.File;
import java.io.IOException;

/*
创建文件的三种方式
 */
public class FileCreate {
    public static void main(String[] args) {
        //第一种方式 new File(String pathname) //根据路径构建一个File对象
//        String filePath = "D:\\text\\news1.txt";
//        File file = new File(filePath);
//        try {
//            file.createNewFile();
//            System.out.println("创建成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //第二种方式 new File(File parent,String child) //根据父目录文件 + 子路经构建new

//        File file1 = new File("D:\\text");
//        String filePathName = "news2.txt";
//        File file2 = new File(file1, filePathName);
//        try {
//            file2.createNewFile();
//            System.out.println("创建成功~");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        //第三种方式 File(String parent,String child) //根据父目录 + 子路径构建
        String file01 = "D:\\text";
        String file02 = "news03.txt";
        File file = new File(file01, file02);
        try {
            file.createNewFile();
            System.out.println("创建成功：new03.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
