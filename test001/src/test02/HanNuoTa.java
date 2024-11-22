package test02;
/*
汉诺塔
"练习递归"
 */
public class HanNuoTa {
    public static void main(String[] args) {

    }
}


class Tower{
    public void move(int num ,char a,char b,char c){
        if (num ==1){
            System.out.println(a+"->" + b);
        }else {
            move(num-1,a,c,b);
            System.out.println(a+"->"+c);
            move(num-1,b,a,c);
//            System.out.println();
        }
    }
}