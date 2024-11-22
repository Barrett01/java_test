package test02;

/*
定义一个Person类 使用冒泡来从大到小的排序，age
 */
public class Test07 {
    public static void main(String[] args) {
        PersonTest07 person1 = new PersonTest07("张三", 25, "掏粪工");
        PersonTest07 person2 = new PersonTest07("李四", 55, "牛马");
        PersonTest07 person3 = new PersonTest07("王五", 2, "小孩");
        PersonTest07 person4 = new PersonTest07("刘六", 66, "环卫工");
        PersonTest07 person5 = new PersonTest07("洪七", 88, "乞丐");
        PersonTest07[] array = {person1,person2,person3,person4,person5};
        PersonTest07 person = null;
        for (int i = 0 ; i < array.length-1;i++){
            for (int j = 0 ; j< array.length-i-1;j++){

                if (array[j].getAge()>array[j+1].getAge()){
                    person = array[j];
                    array[j] = array[j+1];
                    array[j+1] = person;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
class PersonTest07{
    private String name;
    private int age;
    private String job;

    public PersonTest07(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return this.name+"\t"+this.age+"\t"+this.job;
    }
}
