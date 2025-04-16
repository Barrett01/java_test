package TestFX;
/*
泛型的说明
 */
public class genneric01 {
    public static void main(String[] args) {
        FxPerson<String> hsp = new FxPerson<>("hsp");
        String f1 = hsp.f();
        System.out.println(f1);
        hsp.t();

        FxPerson<Integer> i = new FxPerson<>(1000);
        Integer f2 = i.f();
        System.out.println(f2);
        i.t();
    }
}

class FxPerson<E>{
    //E 表示s的类型 该数据类型定义FxPerson对象的时候指定，即在编译期间，就确定E是什么类型
    E s;

    public FxPerson(E s) {
        this.s = s;
    }
    public E f(){
        return s;
    }
    public void t(){
        System.out.println(s.getClass());
    }

}
