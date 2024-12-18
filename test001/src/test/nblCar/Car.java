package test.nblCar;
//汽车类 成员内部类练习
public class Car {
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air{
        public void flow(){
            if(temperature > 35){
                System.out.printf("空调吹冷气~~");
            } else if (temperature < 0) {
                System.out.println("空调吹暖气~~");
            }else {
                System.out.println("空调处于关闭状态");
            }
        }
    }
    public Air getAir(){
        return new Air();
    }
}
