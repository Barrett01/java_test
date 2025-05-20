package FanS;
/*
通过反射创建实例
1，方式一：调用类中的public修饰的无参构造器
2，方式二：调用类中的指定构造器
3，Class类相关方法
newInstance：调用类中的无参构造器，获取对应类的对象
getConstructor（Class..clazz）：根据参数列表，获取对应的public构造器对象
getDecalaredConstructor(Class..clazz)：根据参数列表，获取对应的所有构造器对象
4，Constructor类相关方法
setAccessible：爆破（使用反射可以访问private构造器/方法/属性，反射面前，都是纸老虎）
constructor1.setAccessible(true);
newlnstance(Object..obj):调用构造器
 */


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflecCreateInstanceFs {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //先获取User类的Class对象
        Class<?> aClass = Class.forName("FanS.UserFs");
        //通过Public无参构造器创造实例对象
        Object o = aClass.newInstance();
        System.out.println(o.getClass());
        //通过Public有参构造器创造实例
        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object o1 = constructor.newInstance("张三");
        System.out.println(((UserFs) o1).getName());
        //通过非Public有参构造器创造实例
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(int.class, String.class);
        declaredConstructor.setAccessible(true);//爆破{破坏了封装性：在反射面前一切都是纸老虎}
        Object o2 = declaredConstructor.newInstance(20, "王五");
        System.out.println(((UserFs) o2).getName() + "\t" + ((UserFs) o2).getAge());


    }
}

class UserFs {
    private int age;
    private String name;

    public UserFs() {
    }

    public UserFs(String name) {
        this.name = name;
    }

    private UserFs(int age) {
        this.age = age;
    }

    private UserFs(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
