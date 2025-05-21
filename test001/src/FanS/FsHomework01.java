package FanS;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FsHomework01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("FanS.privateTest");
        Object o = aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "hellokitty002");
//        System.out.println(name.get(o));
        Method getName = aClass.getDeclaredMethod("getName");

        System.out.println(getName.invoke(o));
    }
}
class privateTest{
    private String name = "hellokitty";

    public String getName() {
        return name;
    }
}