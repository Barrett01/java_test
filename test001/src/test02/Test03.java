package test02;
/*

猴子吃桃子问题：
有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！
以后每天猴子都吃其中的的一半，然后再多吃一个；
当到第10天时，想再吃时{还没吃}，发现只有一个桃子了
问题：最初共有多少个桃子
 */
public class Test03 {
    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        System.out.println(monkey.peachesMany(10));
    }
}
class Monkey{
//    public int peaches;
    public int peachesMany(int day){
//        思路没问题 但是这个规律 没仔细想明白
        if (day <=1){
            return day;
        }
        return peachesMany(day-1)*2+2;//这里+2 是规律所得


//        if (day == 10){
//            return 1;
//        }else if (day >= 1 && day <= 9){
//            return (peachesMany(day+1)+1)*2;
//        }else {
//            return -1;
//        }


    }
}
