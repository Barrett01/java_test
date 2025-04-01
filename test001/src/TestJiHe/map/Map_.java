package TestJiHe.map;
/*
map的特性
 */
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1",10000);
        map.put("no2",20000);
        map.put("no1",40000);
        map.put(new person(),new car());
    /*
    解读：
    1，k-v 最后是HashMap$Node node = new Node(hash,key,vey,null)
    2，k-v 为了方便程序员的遍历，还会创建EntrySet集合，该集合存放的元素的类型Entry
    3，entrySet中，定义的类型是Map.Entry,但是实际上存放的还是HashMap$Node
    4，当把HashMap$Node 对象，存放到entrySet方便我们遍历，因为Map.Entry提供了重要的方法
    “getKey（）”“getVule（）”
     */
        Set set = map.entrySet();
        System.out.println(set.getClass());//class java.util.HashMap$EntrySet
        for (Object o : set) {
            System.out.println(o.getClass());//class java.util.HashMap$Node
            //从HashMap$Node取出k-v
            Map.Entry entry = (Map.Entry) o; //向下转型
            System.out.println(entry.getKey()+":" + entry.getValue());
        }
        Set set1 = map.keySet();
        System.out.println(set1.getClass());
        Collection values = map.values();
        System.out.println(values.getClass());
    }
}

class car{

}
class person{

}
