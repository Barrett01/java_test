package test01;
/*(
输出100以内不能被5整除的数，每五个一行
 */
public class test10 {
    public static void main(String[] args) {
        int count = 0;
        for (int i=1 ;i<=100;i++){
            if (i%5 !=0){
                count++;
                System.out.print(i+"\t");
                while (count==5){
                    System.out.println();
                    count=0;
                    break;
                }
            }
        }
    }
}
