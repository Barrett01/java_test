package TestDuoXC;
//守护线程
//守护线程：一般是为工作线程服务的，当所有的使用户线程结束，守护线程自动结束；
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        Thread thread = new Thread(myDaemonThread);
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("宝强在工作");
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("某某女性正在打女权");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

