package FanS;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FsHomeWork02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor);
        }

        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        String fileAllpath  = "D:\\text\\mynew.txt";

        Object o = declaredConstructor.newInstance(fileAllpath);
        Method createNewFile = aClass.getMethod("createNewFile");//主要是这里调用什么方法
        createNewFile.invoke(o);//创建了文件
        System.out.println("文件创建成功"+fileAllpath);
    }
}

