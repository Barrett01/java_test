package testyichang;

import java.util.Scanner;

//如果用户输入的不是一个整数，那就反复输入，直到输入一个整数为止
public class YCtest02 {
    public static void main(String[] args) {
        String next = "";
        int num = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个整数：");
            next = scanner.next();
            try  {
                num = Integer.parseInt(next);
                System.out.println(next + "为一个整数");
                return;
            } catch (Exception e) {
                System.out.println("输入的整数异常");
                e.printStackTrace();
            } finally {
                System.out.println("------------");
            }
        }


    }
}
