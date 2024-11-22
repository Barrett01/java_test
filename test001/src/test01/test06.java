package test01;

import java.util.Scanner;

/*
实现登录验证，有三次机会，如果用户名为“懒鱼“ 密码”666“提示登录成功，否则提示还有几次机会
 */
public class test06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        for (int i = 3 ; i >= 1; i--){
            System.out.println("请输入用户名：");
            String name = scanner.next();
            System.out.println("请输入密码：");
            String pswd = scanner.next();
//            pswd = pswd
            if ("懒鱼".equals(name) && "666".equals(pswd)){
                System.out.println("登录成功");
                break;
            }else {
                System.out.println("登录失败，还有"+(i-1)+"次机会");
            }

        }
    }
}
