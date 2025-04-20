package TestDuoXC;
/*
模拟三个窗口售票
1,会出现多卖的情况
 */
public class SellTicket {
    public static void main(String[] args) {
        SellTicket01 sellTicket01 = new SellTicket01();
        SellTicket01 sellTicket02 = new SellTicket01();
        SellTicket01 sellTicket03 = new SellTicket01();

        new Thread(sellTicket01).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket03).start();

    }
}
class SellTicket01 implements Runnable{
    private static int ticket = 100;
    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket--;
            System.out.println("还有多少票："+ticket);
            if(ticket <= 0){
                break;
            }
        }
    }
}
