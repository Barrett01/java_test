package TestFX;

import java.util.*;

/*
创建三个学生对象，放入hashSet中使用
放入hashmap中 要求 key为Sting name Value就是学生对象
使用两种方式遍历
 */
public class FxGenneric2 {
    public static void main(String[] args) {
        FxStudent zs = new FxStudent("zs", 25);
        FxStudent ws = new FxStudent("ws", 25);
        FxStudent lmc = new FxStudent("lmc", 25);
        //初始化并添加元素
        HashSet<FxStudent> setStudent = new HashSet<FxStudent>();
        setStudent.add(zs);
        setStudent.add(ws);
        setStudent.add(lmc);

        HashMap<String, FxStudent> stringFxStudentHashMap = new HashMap<>();
        stringFxStudentHashMap.put(zs.getName(), zs);
        stringFxStudentHashMap.put(ws.getName(), ws);
        stringFxStudentHashMap.put(lmc.getName(), lmc);

        //遍历打印
        Iterator<FxStudent> iterator = setStudent.iterator();
        while (iterator.hasNext()) {
            FxStudent student = iterator.next();
            System.out.println(student.getName());
        }
        System.out.println("==============我是分割线=============");
        Set<Map.Entry<String, FxStudent>> entries = stringFxStudentHashMap.entrySet();
        for (Map.Entry<String, FxStudent> entry : entries) {
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }


    }
}

class FxStudent{
    private String name;
    private int age;

    public FxStudent(String name, int age) {
        this.name = name;
        this.age = age;
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
}
