package TestDuoXC;

/*
Runnbale 使用了代理模式
模拟代理模式
 */
public class Thread03 {
    public static void main(String[] args) throws InterruptedException {
        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}
class Animal{}
class Tiger extends Animal implements Runnable{

    @Override
    public void run() {
        System.out.println("嗷嗷叫");
    }
}
//线程代理类， 模拟了一个极简的Thread类
class ThreadProxy implements Runnable {
    private Runnable target = null;//属性 类型Runnable

    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();//真正实现多线程{模拟}
    }

    public void start0() {
        run();
    }
}


