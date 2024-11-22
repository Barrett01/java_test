package test02;
/*
练习可变参数
 */
public class Test04 {
    public static void main(String[] args) {
        Student student = new Student();
        String s = student.showScore("huanghao", 48.45, 7, 8, 9);
        System.out.println(s);
    }
}

class Student{

    public double chengji;
    public String name;

    public String showScore(String name, double ... chengji){
        double chengjiz = 0;
        for (int i =0 ;i<chengji.length;i++){
            chengjiz +=  chengji[i];
        }
        return name+"的"+chengji.length+"课 分别是："+chengjiz;
    }
}
