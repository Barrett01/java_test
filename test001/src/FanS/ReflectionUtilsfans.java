package FanS;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
演示如何通过反射 获取类的结构信息
 */
public class ReflectionUtilsfans {
    public static void main(String[] args) {

    }

    //第一组API
    @Test
    public void api_01() throws ClassNotFoundException {
        Class<?> personCls = Class.forName("FanS.PersonFs");
        //得到Class对象
//        1,getName：获取全类名
        System.out.println(
                personCls.getName()
        );
//        2,getSimpleName：获取简单类名
        System.out.println(personCls.getSimpleName());
//        3,getFields：获取所有public修饰的属性，包含本类以及父类的

        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("----------------");
//        4,getDeclared Fields：获取本类中所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("\t" + field.getName());
        }
        System.out.println("------------");
//        5,getMethods：获取所有public修饰的方法，包含本类以及父类
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("-------------");
//        6,getDeclaredMethods：获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("只拿到本类的所有方法:" + method.getName());
        }
        System.out.println("----------------");
//        7,getConstructors：获取本类的所有public修饰的构造器
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类public构造器:" + constructor.getName());
        }
//        8,getDeclaredConstructors：获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println("本类所有的构造器" + constructor.getName());
        }
        System.out.println("---------------------");
//        9,getPackage：以Package形式返回包信息
        Package aPackage = personCls.getPackage();
        System.out.println("返回包信息:"+aPackage.getName());
        System.out.println("--------------");
//        10,getSuperClass：以Class形式返回父类信息
        Class<?> superclass = personCls.getSuperclass();
        System.out.println("父类包的信息"+superclass.getName());
        System.out.println("------------");
//        11,getInterfaces：以Class形式返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息:" + anInterface.getName());
        }
        System.out.println("----------");
//        12,getAnnotations：以Annotation形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());//注解信息直接输出就好了 不用getName
        }
    }
}

class FsA {
    public String hobby;

    public void hi() {
    }

    public FsA() {
    }

    public FsA(String hobby) {
        this.hobby = hobby;
    }
}
interface JkFs{
    public void jkfs();
}
@Disabled
class PersonFs extends FsA  implements JkFs{
    //四种访问权限的属性和四种反问权限的方法
    public String name;
    protected int age;
    String job;
    private double sal;

    public PersonFs() {
    }

    public PersonFs(String name, int age, double sal, String job) {
        this.name = name;
        this.age = age;
        this.sal = sal;
        this.job = job;
    }

    private PersonFs(String name) {
        this.name = name;
    }

    public void m1() {

    }

    protected void m2() {

    }

    void m3() {

    }

    private void m4() {

    }

    @Override
    public void jkfs() {
        System.out.println("实现接口了");
    }
}


