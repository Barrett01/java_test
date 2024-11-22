package test01;
/*
编写类AA 有一个方法：判断一个数字是奇数还是偶数，返回boolean
 */
public class test18 {
    public static void main(String[] args) {
        AA aa = new AA();

        System.out.println(aa.panDuan(89));
    }
}

class AA{
    public boolean panDuan(int count){
        if (count %2 == 0){
            return true;
        }
        else {
            return false;
        }
    }
}
