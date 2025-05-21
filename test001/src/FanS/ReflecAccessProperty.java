package FanS;

import java.lang.reflect.Field;
/*
通过反射访问类中的成员
 */
public class ReflecAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //通过反射得到类
        Class<?> aClass = Class.forName("FanS.StudentFs");
        Object o = aClass.newInstance();//得到一个对象
//        System.out.println(o.getClass());
        Field name = aClass.getField("name");//可以返回public的属性
        name.set(o,"张三");
        System.out.println(name.get(o));

        Field age = aClass.getDeclaredField("age");
        age.setAccessible(true);//因为是private属性 需要爆破

//        age.set(o,18);
        age.set(null,18);//因为是static 所以在类加载的时候就可以
        System.out.println(age.get(o));

    }
}
class StudentFs{
    public String name;
    private static int age;
    public StudentFs() {

    }
    public StudentFs(String name, int age) {
        this.name = name;
        this.age = age;
    }
}