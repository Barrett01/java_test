package TestDuoXC;

public class XCHomeWork02 {
    public static void main(String[] args) {
        CCka cCka = new CCka();
        Thread thread1 = new Thread(cCka);
        thread1.setName("Thread1");
        Thread thread2 = new Thread(cCka);
        thread2.setName("Thread2");
        thread1.start();
        thread2.start();
    }
}

class CCka implements Runnable {
    private boolean loop = true;
    private int Amount = 10000;

    public /*synchronized*/ void wallet() {
        synchronized (this) {

            if (Amount < 1000) {
                loop = false;
                System.out.println("余额不足");
                return;
            }
            Amount = Amount - 1000;
            System.out.println(Thread.currentThread().getName() + "取出1000" + "还剩余额：" + Amount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void run() {
        while (loop) {
            wallet();
        }
    }
}
