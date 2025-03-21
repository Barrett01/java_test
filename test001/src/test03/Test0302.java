package test03;
/*
使用平常思维实现二进制转换为10进制
二进制数：1010

十进制数：1*2^3 + 0*2^2 + 1*2^1 + 0*2^0 =  8 + 0 + 2 +0 = 10
 */
public class Test0302 {
public  int binaryToDecimal(String inMsg){
    int x = 0;
    int mul = 1;
    for (int i = inMsg.length()-1; i >=0;i--){
        x += mul * (inMsg.charAt(i) == '1'?1:0);
        mul *= 2;
        //这个地方不对 明天查一查{已修改，第一是忽略下标为0的情况，第二返回值存在问题}

    }
    System.out.println((x));
    return x;
}

    public static void main(String[] args) {
        Test0302 test0302 = new Test0302();
        int i = test0302.binaryToDecimal("10101001");
        System.out.println("10101001的十进制为" + i);
    }
}
