package testregexp.regexp;

import java.util.regex.Pattern;

/*
要求验证 是不是整数或者小数
提示：这个提要考虑正数和负数
比如：123 -1234 24.98 -0.089
 */
public class HomeWord02ReExp {
    public static void main(String[] args) {

        String content = "-98.08";

        String strRe = "^[-+]?([1-9]\\d+|0)(\\.\\d+)?$";
        if (content.matches(strRe)) {
            System.out.println("是整数或者小数");
        }
    }
}
