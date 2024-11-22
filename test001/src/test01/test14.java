package test01;
/*
使用二维数组 打印一个10行的杨辉三角
 */
public class test14 {
    public static void main(String[] args) {
        int[][] array = new int[10][];
        for (int i = 0 ; i<= array.length-1;i++){
            array[i] = new int[i+1];
            for (int j = 0 ; j<= array[i].length-1;j++){
                if ( j == 0 || j == array[i].length-1){
                    array[i][j] = 1;
                }else {
                    array[i][j] = array[i-1][j-1]+array[i-1][j];
                }
            }
        }

        //输出
        for (int i = 0 ;i<=array.length-1;i++){
            for (int j =0;j<=array[i].length-1;j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
