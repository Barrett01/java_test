package test01;
/*
统计1-200之间能被5整除，但是不能被3整除的个数
 */
public class Test03 {
    public static void main(String[] args) {
        int num = 0;
        for (int i  = 1 ; i < 200 ; i ++){
            if ((i%5 == 0) && (i%3 != 0) ){
                num += 1;
            }

        }
        System.out.println("num= "+num);
    }
}
