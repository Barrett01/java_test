package TestDuoXC;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        ThreadzXc threadzXc = new ThreadzXc();
        Thread thread = new Thread(threadzXc);

        for (int i = 1; i <= 10; i++) {
            Thread.sleep(100);
            System.out.println("hi " + i);
            if (i == 5) {
                thread.start();
                thread.join();//启动之后 立即插队
            }
        }
    }
}

class ThreadzXc implements Runnable {
    private static int time = 1;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("hello" + time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            time +=1;
            if (time == 11) {
                break;
            }
        }
    }
}
