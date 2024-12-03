package test03;

public class Test0308 {
    public static void main(String[] args) {
        A08 a08 = new A08();
        a08.f2();
    }
}
class A08{
    private String name = "张山";
    public void  f2(){
        class B08{
            private final String name = "张三";
            public void show(){
                System.out.printf("name:"+A08.this.name);
            }
        }
        B08 b = new B08();
        b.show();
    }
}

