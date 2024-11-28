package test03;
//练习抽象方法
public class Test0305 {
    public static void main(String[] args) {
        Animal cart = new Cart();
        Animal dog = new Dog();
        cart.shout();
        dog.shout();
        KongLong kongLong = new KongLong();
        kongLong.workKL(new Animal() {
            @Override
            public void shout() {
                System.out.println("恐龙的叫声： 啊呜~~");
            }
        });

    }
}
abstract class Animal{
   public abstract void shout();
}

class Cart extends Animal{
    @Override
    public void shout() {
        System.out.println("猫喵喵的叫~~");
    }
}

class Dog extends Animal{
    @Override
    public void shout() {
        System.out.println("狗汪汪的叫~~");
    }
}
//测试匿名内部类
class KongLong {
    public void workKL( Animal animal){
         animal.shout();
    }
}