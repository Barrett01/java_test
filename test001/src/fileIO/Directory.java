package fileIO;

import org.junit.jupiter.api.Test;
/*
调用api来判断是否有文件并删除文件
 */
import java.io.File;

public class Directory {
    public static void main(String[] args) {


    }
    @Test
    public void test() {
        String filepath = "D:\\text\\news1.txt";
        File file = new File(filepath);
        if (file.exists()) {
            if(file.delete()){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("文件不存在");
        }
    }
}
