package TestDuoXC;
//打印计算机cpu数
public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println("多少个可用cpu，处理器："+i);

    }
}
