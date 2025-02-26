package TestChangYongLei;

//测试String特性：两个对象拼接时的反应
public class StringExercise {
    public static void main(String[] args) {
        String a = "hello";
        String b = "world";
        //解读：
        //1，先创建一个 StringBuileder sb =  StringBuilder();
        //2，执行 sb.append("hello");
        //3，sb.append("world");
        //4，String c = sb.toString();
        String c = a + b;

    }
}
