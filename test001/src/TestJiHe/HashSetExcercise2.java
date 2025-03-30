package TestJiHe;

import java.util.HashSet;
import java.util.Objects;
//练习之name 和 birthday 相同时认为是相同员工
public class HashSetExcercise2 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Employee2 hh = new Employee2("hh", 80000, new MyDate(2000, 10, 10));
        Employee2 hh1 = new Employee2("hh", 20000, new MyDate(2000, 10, 10));
        Employee2 hh2 = new Employee2("hh", 80000, new MyDate(1999, 10, 10));
        hashSet.add(hh);
        hashSet.add(hh1);
        hashSet.add(hh2);
        System.out.println(hashSet);

    }
}

class Employee2 {
    private String name;
    private int sal; //薪水
    private MyDate birthday;//出生年月日

    public Employee2(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee2 employee2 = (Employee2) o;
        return Objects.equals(name, employee2.name) && Objects.equals(birthday, employee2.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday.toString() +
                '}';
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "year=" + year + ", month=" + month + ", day=" + day ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
