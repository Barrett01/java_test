package TestJiHe;

import java.util.LinkedHashSet;
import java.util.Objects;

public class LinkedHashSetExercise {
//LinkedHashSet小练习
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("澳阔",200000));
        linkedHashSet.add(new Car("奥迪",350000));
        linkedHashSet.add(new Car("凯迪拉克",180000));
        linkedHashSet.add(new Car("奥迪",350000));
        System.out.println(linkedHashSet);
    }
}
class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(price, car.price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}