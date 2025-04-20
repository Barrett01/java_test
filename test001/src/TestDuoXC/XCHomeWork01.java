package TestDuoXC;

import jdk.nashorn.internal.ir.CallNode;

import java.util.Scanner;

/*
(1)在main方法中启动两个线程
(2)第1个线程循环随机打印100以内的整数
(3)直到第2个线程从键盘读取了“Q”命令。
 */
public class XCHomeWork01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}
class A extends Thread{
    private static boolean loop =true;
    public void run(){
        while (loop){
            //随机生成1-100的整数
            System.out.println((int)(Math.random()*100+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public static void setLoop(boolean loop) {
        A.loop = loop;
    }
}

class B extends Thread{
    private  A a;
    private Scanner sc = new Scanner(System.in);
    public B(A a){
        this.a = a;
    }
    @Override
    public void run() {
        while (true){
            System.out.println("请输入指令：");
            char key = sc.next().toUpperCase().charAt(0);
            if (key == 'Q'){
                a.setLoop(false);
                System.out.println("B退出进程");
                break;
            }
        }
    }
}

