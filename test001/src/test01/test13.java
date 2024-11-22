package test01;
/*
请求出一个数组int[] 的最大值，并得到对应的下表
 */
class ts01{
    public int max(int[] a){
        int max =0;
//        for (int i = 0 ; i<=a.length/2;i++){
//            max = Math.max(a[i],a[a.length-1-i]);
//        }
        int maxIndes= 0;
        for (int i = 0 ; i< a.length-1;i++){
            if (a[i] > a[i+1]){
                max = a[i];
                a[i] = a[i+1];
                a[i+1] = max;
                maxIndes =i;
            }
        }

        System.out.println(max);
        System.out.println("最大下标："+maxIndes);
        return max ;
    }
}
public class test13 {

    public static void main(String[] args) {
        int[] a = new int[]{2,7,8,2,9,69,45,43,99,888,775,33,45};
        ts01 ts01 = new ts01();
        ts01.max(a);
    }


}

