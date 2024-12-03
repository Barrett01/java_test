package test03;

public class Test0309 {

}

//交通类的接口
interface Vehicles{
    public void work();
}
class Horse implements Vehicles{
    public void work(){
        System.out.println("一般情况使用马儿");
    }
}
class Boat implements Vehicles{
    public void work(){
        System.out.println("过河使用小船");
    }
}

class VehiclesFatory09{
    public Horse getHorse(){
        return new Horse();
    }
    public Boat getBoat(){
        return new Boat();
    }
}

class PerSon09{
 private String name;
 private Vehicles vehicles09;

    public PerSon09(String name, Vehicles vehicles09) {
        this.name = name;
        this.vehicles09 = vehicles09;
    }

    public void passRiber(){
 }
}