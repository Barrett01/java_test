package test02;

/*
练习抽象类
模板模式
 */
public class Test09 {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.caleTimes();
    }
}

//父类 相当于模板
abstract class Template {
    public abstract void job();

    public  void caleTimes() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }
}

//子类来使用
class AA extends Template {

    long num = 0;
    @Override
    public void job() {
        for (long i = 1; i <= 900000; i++) {
            num += i;
        }
    }
}