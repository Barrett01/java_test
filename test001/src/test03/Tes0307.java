package test03;
//局部内部类的使用
public class Tes0307 {
    public static void main(String[] args) {
        A a = new A();
        a.f1();


    }
}

class A {
    private String name = "张三";

    public void f1() {
        class B {
            private final String name = "张胜男";

            public void show() {
                System.out.println(A.this.name);
            }
        }
        B b = new B();
        b.show();
    }


}
