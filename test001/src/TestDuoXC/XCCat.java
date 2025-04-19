package TestDuoXC;

public class XCCat{
    public static void main(String[] args) throws InterruptedException {
        XCat xcat = new XCat();
        xcat.start();//启动线程
        //说明main启动一个子线程的时候，主线程不会停止
        System.out.println("主线程继续执行："+Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程"+i);
            Thread.sleep(1000);
        }
    }
}
class XCat extends Thread{
    int time = 0;
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println("喵喵"+Thread.currentThread());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            time++;
            if (time ==80){
                break;
            }
        }

    }
}
