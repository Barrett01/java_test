package test02;

public class Test06 {
    public static void main(String[] args) {

        PersonTest06 jock = new PersonTest06("jock", 34);
        System.out.println(jock.say());
        StudentTest06 student = new StudentTest06("张三", 24, "01", 99);
        String say = student.say();
        System.out.println(say);
    }
}

class  PersonTest06{
    private String name;
    private int age;

    public PersonTest06(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String say(){
        return "name="+name+"\tage="+age;
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


class StudentTest06 extends PersonTest06{
    private String id;
    private double score;

    public StudentTest06(String name, int age, String id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public String say(){
        return super.say()+ "\tid="+id+"\tscore="+score;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}