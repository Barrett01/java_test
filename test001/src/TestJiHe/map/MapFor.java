package TestJiHe.map;
//遍历循环练习
//三组
import java.util.*;

public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("zs",23);
        map.put("xs",13);
        map.put("ys",33);
        map.put("yzs",25);
       //第一组 先取出Key
        System.out.println("=========第一组========");
        Set keySet = map.keySet();
        System.out.println("第一种方法：");
        //增强for循环
        for (Object key :keySet){
            System.out.print(key+":"+map.get(key)+"\t");
        }
        System.out.println("\n"+"第二种方法:");
        //迭代器
        Iterator iterator = keySet.iterator();
        while(iterator.hasNext()){
            Object key = iterator.next();
            System.out.print(key+":"+map.get(key)+"\t");
        }

        //第二组 value
        System.out.print("\n"+"=========第二组=====");
        Collection values = map.values();
        System.out.println("\n"+"第一种方法:");

        for (Object value : values){
            System.out.print(value+"\t");
        }
        System.out.println("\n"+"第二种方法:");
        //迭代器
        Iterator iterator1 = values.iterator();
        while(iterator1.hasNext()){
            Object value = iterator1.next();
            System.out.print(value+"\t");
        }

        //第三组 EntrySet 获取k-v
        System.out.print("\n"+"=======第三组=======");
        Set entrySet = map.entrySet();
        System.out.println("\n"+"第一种方法:");
        for (Object entry :entrySet){
            System.out.print(entry.getClass());
            Map.Entry m = (Map.Entry)entry;
            System.out.print(m.getKey()+"\t"+m.getValue()+"\t\t");
        }

        System.out.println("\n"+"第二种方法:");
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()){
            Object nextEntry = iterator2.next();
            System.out.print(nextEntry.getClass());
            Map.Entry nextEntry1 = (Map.Entry) nextEntry;//HashMap$Node 不能直接getkey getvalue
            System.out.print(nextEntry1.getKey()+"\t"+nextEntry1.getValue()+"\t\t");
        }
    }
}
