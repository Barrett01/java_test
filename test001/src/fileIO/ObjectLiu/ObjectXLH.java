package fileIO.ObjectLiu;

import org.junit.jupiter.api.Test;

import java.io.*;

public class ObjectXLH {
    public static void main(String[] args) {

    }

    //反序列化
    @Test
    public void objectInputStream() throws IOException, ClassNotFoundException {
        String filePath = "D:\\text\\objectOutputStream.txt";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

        System.out.println(objectInputStream.readInt());

        System.out.println(objectInputStream.readDouble());

        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readUTF());
//        System.out.println(objectInputStream.readObject()); 必须要和序列化一直的顺序；
        Object dog = objectInputStream.readObject();
        System.out.println(dog);
        System.out.println(dog.getClass());
        Dog dog2 = (Dog) dog;//想实现向下转型 必须让dog处于能访问到的状态
        System.out.println(dog2.getName());
        objectInputStream.close();

    }

    //序列化
    @Test
    public void objectOutputStream() throws IOException {
        String filePath = "D:\\text\\objectOutputStream.txt";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        objectOutputStream.writeInt(100);
        objectOutputStream.writeDouble(100.0);
        objectOutputStream.writeBoolean(true);
//        objectOutputStream.writeChar('a');
//        objectOutputStream.writeByte('b');
        objectOutputStream.writeUTF("hello");
        objectOutputStream.writeObject(new Dog("旺财", 5, "blue", new Master()));
        objectOutputStream.close();
        System.out.println("序列化完成");

    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    // 序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient修饰的成员
    private static String nation;
    private transient String color;
    // 序列化对象时，要求里面属性的类型也需要实现序列化接口
    private Master master = new Master();
    private static final long serialVersionUID = 1L;//序列化 版本号

    public Dog(String name, int age, String color, Master master) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.master = master;
    }

    @Override
    public String toString() {
        return "Dog [name=" + name + ", age=" + age+"]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static String getNation() {
        return nation;
    }

    public static void setNation(String nation) {
        Dog.nation = nation;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
}

class Master implements Serializable {//dog使用这个类做类型 这个必须要序列化
}
