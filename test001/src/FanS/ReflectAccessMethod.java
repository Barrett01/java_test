package FanS;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//通过反射来爆破方法
public class ReflectAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> booClass = Class.forName("FanS.BossFs");
        Object bossFs = booClass.newInstance();//的到对象

//        Method hi = booClass.getMethod("hi", String.class);//调用public的hi方法
        //得到hi方法对象
        Method hi1 = booClass.getDeclaredMethod("hi", String.class);
        //重点注意 方法名称后面是 ：类型.class
        hi1.invoke(bossFs, "小黄");

        Method say = booClass.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);

        System.out.println(say.invoke(bossFs, 8, "不为",'2'));
        System.out.println(say.invoke(null,8,"不等于",'i'));//因为是静态的方法


    }
}

class BossFs {
    public int age;
    private static String name;

    public BossFs() {
    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String name) {
        System.out.println(name + "说：hi");
    }
}
