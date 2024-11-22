package test02;

/*
判断两个Person对象的内容是否相等
如果两个Person对象的各个属性值都一样，则返回true，反之false；
 */
public class Test05 {
    public static void main(String[] args) {
        PersonTest05 zhangsan = new PersonTest05("zhangsan", 28);
        PersonTest05 lisi = new PersonTest05("zhangsan", 28);
        System.out.println(zhangsan.equals(lisi));
//        Scanner scanner = new Scanner(System.in);

    }
}


class PersonTest05 {
    private String name;
    private int age;

    public PersonTest05() {
    }

    public PersonTest05(String name, int age) {
        setName(name);
        setAge(age);
      
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

    //两个对象的比较 重写equals


    @Override
    public boolean equals(Object obj) {
//        return super.equals(obj);

        if (this == obj) {
            return true;
        }
        if (obj instanceof PersonTest05) {
            PersonTest05 p = (PersonTest05) obj;
            return (this.name).equals(p.name) && (this.age) == p.age;
        }
        return false;
    }
}

