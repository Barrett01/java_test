package test03;
//练习匿名内部类
public class Test0306 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Calculate() {
            @Override
            public double work(double n1, double n2) {
                return n1+n2;
            }
        },20.0,10.0);
    }
}

interface Calculate{
    public double work( double n1,double n2);
}
class Cellphone {
   public void testWork(Calculate calculate,double n1,double n2){
       double result = calculate.work(n1, n2);
       System.out.println("结果为："+result);
   }

}
