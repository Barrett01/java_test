package MTQTest;

public class HorseChessBoard {
    private static int x =6;//表示col
    private static int y =6;//表示row
    private static int[][] chessBoard = new int[x][y];//棋盘
    private static boolean[] visited = new boolean[x * y];//记录某个位置是否走过
    private static boolean finished = false;//记录马儿是否遍历完棋局

    public static void main(String[] args) {


        
        //输出当前这个棋盘的情况
        for (int[] rows : chessBoard) {
            for (int step : rows) {
                System.out.print(step+"\t");
            }
            System.out.println();
        }


    }
    //《贪心算法》优化

    //核心功能 能否走通{需要用到遍历}
    //1，遍历棋盘 遍历成功 就把finished设置为true
    //2，将马走的每一步step 记录到chessBoard

    //<列表>-记录能走{下一步}的所有路径
}
