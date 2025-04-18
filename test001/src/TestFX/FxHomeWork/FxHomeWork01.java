package TestFX.FxHomeWork;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
定义个泛型类DAO，在其中定义一个Map成员变量，Map的键为String 类型，值为T类型。
分别创建以下方法: (1) public void save(String id,T entity):保存T类型的对象到Map成员变量
(2) public T get(String id):从map中获取id对应的对象
(3) public void update(String id,T entity):替换 map 中key为id的内容,改为entity对象
(4) public List list):返回map中存放的所有T对象
(5) public void delete(String id):删除指定id对象
定义一个 User类:
该类包含:private成员变量(int类型) id,age; (String类型)name。
创建 DAO 类的对象，分别调用其save、get、update、list、delete方法来操作User对象，使用 Junit 单元测试类进行测试。
 */
public class FxHomeWork01 {
    public static void main(String[] args) {

    }
    @Test
    public void testList() {
        DAO<User> dao = new DAO<>();
        dao.save("001", new User(1, "hsp", 20));
        dao.save("002", new User(2, "hap", 23));
        dao.save("003", new User(3, "hmp", 25));
        dao.save("004", new User(4, "hhp", 21));
        dao.save("005", new User(5, "hap", 20));

//        User user = dao.get("004");
//        System.out.println(user);
        dao.delete("004");
        List<User> list = dao.list();
        System.out.println(
                list
        );


    }
}
class User {
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString() {
        return id + "-" + name + "-" + age;
    }
}



class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        return new ArrayList<>(map.values());
    }

    public void delete(String id) {
        map.remove(id);
    }

}
