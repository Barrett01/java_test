package test03;

public class Test0303 {
    public static void main(String[] args) {
        Car c1 = new Car();
        System.out.println(c1);
        Car c2 = new Car(100);
        System.out.println(c2);
    }
}
class Car{
    double price = 10;
    static String color = "white";//静态变量只在类加载的时候 进行初始化；new对对象的时候第二次，类不会再加载

    @Override
    public String toString() {
        return price+"\t"+color;
    }
    public Car(){
        this.price =9;
        this.color = "red";
    }
    public Car(double price){
        this.price = price;
    }
}
