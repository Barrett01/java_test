package test02;

import java.util.Random;
import java.util.Scanner;

/*
请编写一个猜拳游戏，有个人Tom。设计他的变量，成员方法，可以可电脑猜拳；
电脑随机生成0，1，2；0表示石头，1表示剪刀 2表示布
 */
public class CaiQuan {
    public static void main(String[] args) throws IllegalAccessException {
        Tom tom = new Tom();
        int isWinCount  = 0 ;//用来记录最后的输赢次数

        //创建双数组来接收局数，tom出拳情况 以及电脑出拳情况
        int arr1[][] = new int[3][3];
        int j = 0;
        //创建单数组来接受输赢情况
        String arr2[] = new String[3];

        Scanner scanner = new Scanner(System.in);
        //三局两胜
        for (int i = 0 ; i < 3 ; i++){
            System.out.println("请输入你要出的拳（0-拳头，1-剪刀，2-布）：");
            int num = scanner.nextInt();
            //获得玩家出拳
            tom.setTomGuessNum(num);
            int tomGuess = tom.getTomGuessNum();
            arr1[i][j+1] = tomGuess;

            //获得机器出拳
            int comGuess = tom.computerNum();
            arr1[i][j+2] = comGuess;

            //进行比较
            String isWin = tom.vsComputer();
            arr2[i] = isWin;
            arr1[i][j] =tom.count;

            //对每局情况进行输出
            System.out.println("=========================================");
            System.out.println("局数\t玩家的出拳\t电脑的出拳\t输赢情况");
            System.out.println(tom.count + "\t" + tomGuess + "\t\t" + comGuess + "\t\t" + tom.vsComputer());
            System.out.println("=========================================");
            System.out.println("\n\n");
            isWinCount = tom.winCount(isWin);
        }
        //对游戏的最终结果进行输出
        System.out.println("局数\\t玩家的出拳\\t电脑的出拳\\t\\t输赢情况");
        for (int a = 0; a < arr1.length; a++) {

            for (int b = 0; b < arr1[a].length; b++) {

                System.out.print(arr1[a][b] + "\t\t\t");
            }

            System.out.print(arr2[a]);
            System.out.println();
        }
        System.out.println("你赢了" + isWinCount + "次");
    }

}



class Tom{
    //核心代码

    //玩家出拳类型
    int tomGuessNum;
    //电脑出拳类型
    int comGuessNum;
    //玩家赢得次数
    int winCountNum;
    int count = 1;//一共比赛3次



    /*
    电脑随机生成的出拳类型
     */
    public int computerNum(){
        Random random = new Random();
        comGuessNum = random.nextInt(3);
        return comGuessNum;
    }

    /*
    玩家的get set方法，校验和拿到数据
     */

    public int getTomGuessNum() {
        return tomGuessNum;
    }

    public void setTomGuessNum(int tomGuessNum) throws IllegalAccessException {
        if (tomGuessNum>2 || tomGuessNum<0){
            throw new IllegalAccessException("数字输入错误");
        }
        this.tomGuessNum = tomGuessNum;
    }

    /*
    比拳结果
     */
    public String vsComputer(){
        if (tomGuessNum == 0 && comGuessNum == 1){
            return "你赢了";
        }else if (tomGuessNum == 1 && comGuessNum == 2){
            return "你赢了";
        } else if (tomGuessNum == 2 && comGuessNum == 0) {
            return "你赢了";
        } else if (tomGuessNum == comGuessNum) {
            return "平局";
        }else {
            return "你输了";
        }
    }


    /*
    记录比赛的总次数
     */

    public int winCount(String s){
        count++;
        if (s.equals("你赢了")){
            winCountNum++;
        }
        return winCountNum;
    }

}
