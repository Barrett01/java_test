package TestDuoXC;
/*
实现接口来 实现多线程
 */
public class Thread02 {
    public static void main(String[] args) throws InterruptedException {
        XcDog dog = new XcDog();
//        dog.start(); 这里不能调用start
        Thread thread = new Thread(dog);
        thread.start();
    }
}
class XcDog implements Runnable{
int time = 0;
    @Override
    public void run() {//这只是个普通方法
        while (true){
            time++;
            try {
                System.out.println("小狗汪汪叫" + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (time == 5){
                break;
            }
        }
    }
}