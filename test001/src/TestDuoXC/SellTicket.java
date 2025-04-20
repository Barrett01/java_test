package TestDuoXC;

/*
模拟三个窗口售票
1,会出现多卖的情况
2，使用synchronized实现线程同步
 */
public class SellTicket {
    public static void main(String[] args) {
        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01(); //要求多个线程的锁对象必须是一个 所以不能这样写
//        SellTicket01 sellTicket03 = new SellTicket01();

        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();

    }
}

class SellTicket01 implements Runnable {
    private static int ticket = 10;
    private boolean loop = true;
   Object object =  new Object();

    //同步方法（静态的）的锁为当前类本身
    //1. public synchronized static void m1() {} 锁是加在 SellTicket03.class 上
   public static synchronized void m1(){}
   public static void m2(){
       synchronized (SellTicket01.class){//不能用synchronized (this)
           System.out.println("锁是加在 SellTicket03.class");
       }
   }

    //1. public synchronized void sell() {} 就是一个同步方法
    //2. 这时锁在 this对象
    //3. 也可以在代码块上写 synchronize ,同步代码块, 互斥锁还是在this对象
    public /*synchronized*/ void sell() {
        synchronized (/*this*/object){
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


    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}
