package TestJiHe.map;
//Properties 的简单使用
import java.util.Properties;

public class Properties_ {
    public static void main(String[] args) {
        Properties properties = new Properties();
//        properties.put(null,"ll");//继承于Hashtable 不能有null
        properties.put("john",100);
        properties.put("jane",200);
        properties.put("tom",300);
        System.out.println(properties);

        //通过k 获取对应的值
        Object o = properties.get("tom");

        System.out.println(properties.getProperty("john"));
        properties.remove("tom");
        System.out.println(properties);
        System.out.println(o);
    }
}
