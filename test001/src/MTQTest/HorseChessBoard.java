package MTQTest;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessBoard {
    private static int x =6;//表示col
    private static int y =6;//表示row
    private static int[][] chessBoard = new int[y][x];//棋盘
    private static boolean[] visited = new boolean[x * y];//记录某个位置是否走过
    private static boolean finished = false;//记录马儿是否遍历完棋局

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard,1,1,1);
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end - start));
        //耗时：23263
        //耗时：6

        //输出当前这个棋盘的情况
        for (int[] rows : chessBoard) {
            for (int step : rows){
                System.out.print(step+"\t");
            }
            System.out.println();
        }


    }
    //《贪心算法》优化
    public static void sort(ArrayList<Point> ps){
      ps.sort(new Comparator<Point>() {
          @Override
          public int compare(Point o1, Point o2) {
              return next(o1).size()-next(o2).size();
          }
      });
    }

    //核心功能 能否走通{需要用到遍历}
    //1，遍历棋盘 遍历成功 就把finished设置为true
    //2，将马走的每一步step 记录到chessBoard
    public static void traversalChessBoard(int[][] chessBoard,int row,int col,int step) {
        //记录走的路径
        chessBoard[row][col] = step;
        //把走过的路径标记，防止重复走
        //x是全局变量
        visited[row *x + col] = true;//相当于一维数组 从0开始的
        //h获取当前点可以走那些位置
        ArrayList<Point> ps = next(new Point(col,row));
        //循环取出并回溯
        sort(ps);
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);//移除并返回值
            if (!visited[p.y * x + p.x]) {//没走过的进行 递归遍历
                traversalChessBoard(chessBoard,p.y,p.x,step+1);
            }
        }
        //退出循环后判断是否成功
        if (step < x * y && !finished){
            //重置
            chessBoard[row][col] = 0;
            visited[row * x + col] = false;
        }else {
            finished = true;
        }

    }

    //<列表>-记录能走{下一步}的所有路径
    public static ArrayList<Point> next(Point curpaint){
       //创建一个数组
        ArrayList<Point> ps = new ArrayList<>();
        //创建一个Point对象（点/位置），准备放入到ps
        Point p1 = new Point();

        //判断 curpaint 是否可以走如下位置，可以的话存入到数组中
        if ((p1.x = curpaint.x - 2)>=0  &&(p1.y =  curpaint.y -1 )>=0 ){
            ps.add(new Point(p1));//这里一定要new Point
        }
        if ((p1.x = curpaint.x-1)>=0 && (p1.y = curpaint.y-2)>=0){
            ps.add(new Point(p1));
        }
        if ((p1.x = curpaint.x+1) <x && (p1.y = curpaint.y-2)>=0){
            ps.add(new Point(p1));
        }
        if ((p1.x = curpaint.x+2) < x && (p1.y = curpaint.y-1)>=0){
            ps.add(new Point(p1));
        }
        if ((p1.x = curpaint.x+2) < x && (p1.y = curpaint.y+1) <y){
            ps.add(new Point(p1));
        }
        if ((p1.x = curpaint.x+1) <x && (p1.y = curpaint.y+2) <y){
            ps.add(new Point(p1));
        }
        //报错的原因 只检查的下限 没检查上线导致的
        if ((p1.x = curpaint.x-1)>=0 && (p1.y = curpaint.y+2)<y){
            ps.add(new Point(p1));
        }
        if ((p1.x = curpaint.x-2)>=0 && (p1.y =  curpaint.y+1)<y){
            ps.add(new Point(p1));
        }
        return ps;
    }

}
