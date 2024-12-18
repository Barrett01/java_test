package test.nblCar;

public class test0310 {
    public static void main(String[] args) {
        Car car = new Car(39);
        Car.Air air = car.getAir();
        air.flow();

    }
}
