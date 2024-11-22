package test01;
/*
打印1-100之间所有能被3整除的数
 */
public class test08 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++){
            if (i % 3 == 0){
                System.out.println(i);
            }
        }
    }
}
