package test02;
/*
练习一个单例模式{饿汉式 和懒汉式}
 */
public class Test08 {
    public static void main(String[] args) {
//        System.out.println(A08.ehan());
        System.out.println(AA08.lhan());
    }
}
//饿汉式
class A08{
    private static A08 a08 = new A08("小红");
    private  String name ;

    private A08(String name) {
        this.name = name;
    }
    public static A08 ehan(){
        return a08;
    }

    @Override
    public  String toString() {
        return a08.name;
    }
}

//懒汉式
class AA08{
    private String name;
    private static AA08 aa08;

    private AA08(String name) {
        this.name = name;
    }
    public static AA08 lhan(){
        if (aa08 == null){
            aa08 = new AA08("小白");
        }
        return aa08;
    }

    @Override
    public String toString() {
        return aa08.name;
    }
}
