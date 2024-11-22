package test02;

public class Test10 {
    public static void main(String[] args) {
//        f1(new If() {
//            @Override
//            public void show() {
//                System.out.println("打印匿名内部类");
//            }
//        });
        f1(new If() {
            @Override
            public void show() {
                System.out.println("第二个");
            }
        });
    }
    public static void f1(If il){
        il.show();
        System.out.println(il.getClass());
    }
}
interface If{
    public void show();

}
