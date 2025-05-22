package FanS;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
利用Class类的forName方法得到File类的class对象
在控制台打印File类的所有构造器
通过newlnstance的方法创建File对象，
并创建E:\mynew.txt文件 提示:创建文件的正常写法如下: File file = new File("d:1laa.txt");
//内存 file.createNewFile0;//方法，才能真正的创建文件
 */
public class FansHomework {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
       for (Constructor<?> constructor : declaredConstructors) {
           System.out.println(constructor);
       }
        System.out.println("=======================");
        String filename = "D://text//mynewt.txt";
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        Object o = declaredConstructor.newInstance(filename);
        Method createNewFile = aClass.getMethod("createNewFile");
        createNewFile.invoke(o);
        System.out.println("创建个成功~");

    }
}
