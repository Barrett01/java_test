package TestJiHe.map;

import java.util.HashMap;
/*
map
验证hashmap的扩容机制
 */
public class HashMapSource02 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        for (int i = 0; i < 12; i++) {
            map.put(new AMap(i),"hsp");

        }
        System.out.println(map);

    }
}
class AMap{
    private int key;


    public AMap(int key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}

