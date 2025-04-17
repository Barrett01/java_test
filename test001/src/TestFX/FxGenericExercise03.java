package TestFX;


import java.util.ArrayList;
import java.util.Comparator;

/**
 * 定义Employee类
 * 1) 该类包含：private成员变量name,sal,birthday，其中 birthday 为 MyDate 类的对象；
 * 2) 为每一个属性定义 getter, setter 方法；
 * 3) 重写 toString 方法输出 name, sal, birthday
 * 4) MyDate类包含: private成员变量month,day,year；并为每一个属性定义 getter, setter 方法；
 * 5) 创建该类的 3 个对象，并把这些对象放入 ArrayList 集合中（ArrayList 需使用泛型来定义），对集合中的元素进行排序，并遍历输出：
 *
 * 排序方式： 调用ArrayList 的 sort 方法 ,
 * 传入 Comparator对象[使用泛型]，先按照name排序，如果name相同，则按生日日期的先后排序。【即：定制排序】
 */
public class FxGenericExercise03 {
    public static void main(String[] args) {
        MyDate myDate1 = new MyDate(2000, 10, 10);
        MyDate myDate2 = new MyDate(2002, 1, 10);
        MyDate myDate3 = new MyDate(1999, 11, 26);

        Employee hh = new Employee("hz", 20000, myDate1);
        Employee zs = new Employee("hsp", 10000, myDate2);
        Employee hsp = new Employee("hsp", 60000, myDate3);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(hh);
        employees.add(zs);
        employees.add(hsp);
//调用ArrayList 的 sort 方法
// 先按照name的字母大小排序{从第一个开始}，如果name相同，则按生日日期的先后排序。【即：定制排序】
        System.out.println("具体了解Comparator的compare参考treeSet，treeMap章节");
        //具体了解Comparator的compare参考treeSet，treeMap章节
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
               if (!(emp1 instanceof Employee && emp2 instanceof Employee)) {
                   System.out.println("Employee is not of type Employee");
                   return 0;
               }
                int i = emp1.getName().compareTo(emp2.getName());
               if (i != 0) {
                   return i;
               }
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });
        for (Employee emp : employees) {
            System.out.println(emp);
        }

    }


}
class Employee{
    private String name;
    private int salary;
    private MyDate birthday;

    public Employee(String name, int salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return name + ", " + salary + ", " + birthday;
    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    public int compareTo(MyDate o) {
        int yearMinus = year - o.getYear();
        if(yearMinus != 0) {
            return  yearMinus;
        }
        //如果year相同，就比较month
        int monthMinus = month - o.getMonth();
        if(monthMinus != 0) {
            return monthMinus;
        }
        //如果year 和 month
        return day - o.getDay();
    }
}
