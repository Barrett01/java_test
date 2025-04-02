package TestJiHe.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
课堂练习
 */
public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        staff hh = new staff(01, "hh", 50000);
        staff lzp = new staff(02, "lpz", 18000);
        staff zj = new staff(03, "zj", 15000);
        map.put(hh.getId(), hh);
        map.put(lzp.getId(), lzp);
        map.put(zj.getId(), zj);
//        System.out.println(map);
//第一种遍历，使用迭代器
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            staff person = (staff) entry.getValue();
            if (person.getSalary() >= 18000) {
                System.out.println("月薪大于1.8k的人:" + person.getName());
            }
        }
//第二种遍历：使用增加for循环
            for (Object object : set) {
                Map.Entry entry1 = (Map.Entry) object;
                staff person1 = (staff) entry1.getValue();
                if (person1.getSalary() >= 18000) {
                    System.out.println(person1.getName() + "是月薪:"+person1.getSalary());
                }
            }


    }

}

class staff {
    private String name;
    private double salary;
    private int id;

    public staff(int id, String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}