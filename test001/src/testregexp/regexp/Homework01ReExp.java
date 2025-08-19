package testregexp.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
规定电子邮件规则为：
只能有一个@
@前面是用户名 可以是a-z A-Z 0-9 _字符
@后面是域名 并且域名只能是英文字符；

 */
public class Homework01ReExp {
    public static void main(String[] args) {
        String qq = "2726205591@qq.com";

        String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";

        Pattern p = Pattern.compile(regStr);
        Matcher m = p.matcher(qq);
        if(m.find()){
            System.out.println("满足格式");
        }else {
            System.out.println("不满足格式");
        }
    }


}
