package test01;

import java.util.Scanner;

/*
统计3个班成绩情况，每个班有5名同学，求出各个班的平均分和所有班级的平均分【成绩键盘输入】
 */
public class test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("");
//        double v = scanner.nextDouble();
        int totalScore = 0;
        for (int i = 1; i<=3; i++){
            int num = 0;
            for (int j = 1 ;j<=2;j++){
                System.out.println("请输入" + i + "年纪" + "第"+j+"个学生的成绩为：");
                double v = scanner.nextDouble();
                num +=v;
                System.out.println("成绩为："+ v);

            }
            System.out.println("总："+num+"平均："+(num/5));
            totalScore += num;

        }

        System.out.println("所有："+totalScore+"平均所有："+(totalScore/5));
        scanner.close();
    }
}
