package MTQTest;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Pattern;

import static MTQTest.HorseChessBoard.next;

public class HorseChessBoard02Test {

    private static int X = 6;//x坐标对应col
    private static int Y = 6;//坐标对应row
    private static int[][] chessBoard = new int[Y][X];//棋盘
    private static boolean[] visited = new boolean[X * Y];//记录某个位置是否走过
    private static boolean finished = false;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard,1,1,1);
        long end = System.currentTimeMillis();
        System.out.println("总的消耗时间为："+(end - start));

        //循环打印棋盘{这里也要注意row是Y坐标 也就是列}
        for (int[] rows :chessBoard){
            for (int step : rows){
                System.out.print(step+"\t");
            }
            System.out.println();
        }
    }
    //算法优化：先使用排序
    public static void sort01(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size()-next(o2).size();
            }
        });
    }
    //核心方法
    //递归查找 step是记录走过的位置
    public static void traversalChessBoard(int[][] chessBoard,int row,int col,int step){
        //按顺序写入走过的顺序{数字}
        chessBoard[row][col] = step; //此处要注意row对应的Y坐标；col对应的X坐标
        visited[row * X + col] = true;//走过的标识，防止重走

        //获得所能走的下一步的集合
        ArrayList<Point> ps = allLocal(new Point(col, row));
        sort01(ps);
        while (!ps.isEmpty()){
            Point p = ps.remove(0);//移除并返回值
            //判断是否走过
            if (!visited[p.y * X + p.x]){
                traversalChessBoard(chessBoard,p.y,p.x,step+1);//回溯
            }
        }
        //跳出循环
        //判断是否满足条件
        if (step < X * Y && !finished){
            //重置
            chessBoard[row][col] = 0;
            visited[row * X + col] = false;

        }else {
            finished = true;
        }
    }

    //写个方法获得下个位置的所有位置的集合
    public static ArrayList<Point> allLocal(Point curPoint){
        //创建列表用于返回
        ArrayList<Point> points = new ArrayList<>();
        //创建对象用于写入
        Point p1 = new Point();
        //开始添加符合情况的位置到集合中去
        if ((p1.x = curPoint.x-2) >=0 && (p1.y = curPoint.y -1)>=0){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x-1)>=0 && (p1.y = curPoint.y-2)>=0){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x+1)<X && (p1.y = curPoint.y-2)>=0 ){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x+2) < X && (p1.y = curPoint.y-1)>=0 ){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x+2) < X && (p1.y = curPoint.y+1) < Y ){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x+1) < X && (p1.y = curPoint.y+2) < Y ){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x-1) >=0 && (p1.y = curPoint.y+2) < Y){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x -2) >= 0 && (p1.y = curPoint.y+1) <Y){
            points.add(new Point(p1));
        }
        return points;
    }

}
