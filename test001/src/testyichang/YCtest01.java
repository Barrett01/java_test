package testyichang;
//快捷键 选中代码 ctrl + alt +t
public class YCtest01 {
    public static void main(String[] args) {
//        Throwable
         int num1 = 10;
         int num2 = 0;

        int res = 0;
        try {
            res = num1 / num2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }


}
