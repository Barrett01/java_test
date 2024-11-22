package test01;
/*
创建一个char类型的26个元素的数组，分别放置‘A’-‘Z’。使用for循环访问所有元素并打印出来
 */
public class test12 {
    public static void main(String[] args) {
        char[] arry = new char[26];
        for (int i = 0; i <= 25; i++){
            arry[i] = (char)('A'+i);
            System.out.println(arry[i]);
        }
    }
}
