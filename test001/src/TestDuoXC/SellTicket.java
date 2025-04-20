package TestDuoXC;

/*
模拟三个窗口售票
1,会出现多卖的情况
 */
public class SellTicket {
    public static void main(String[] args) {
        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01(); //不能这样写
//        SellTicket01 sellTicket03 = new SellTicket01();

        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();

    }
}

class SellTicket01 implements Runnable {
    private static int ticket = 100;
    private boolean loop = true;

    public synchronized void sell() {
        if (ticket <= 0) {
            System.out.println("票已售尽");
            loop = false;
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        --ticket;
        System.out.println("窗口：" + Thread.currentThread().getName() + "售出一张票 剩余票数：" + (--ticket));

    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}
