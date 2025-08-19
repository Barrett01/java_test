package testregexp.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
对一个url进行解析：http://www.sohu.com:8080/abc/index.htm
要求得到协议是什么? http
域名是什么? www.sohu.com
端口是什么? 8080
文件名是什么? index.htm
 */
public class HomeWork03ReExp {
    public static void main(String[] args) {
        String content = "http://www.sohu.com:8080/abc/index.htm";

        String regexp = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.]+)$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(content);
        if (matcher.matches()) {//整体匹配
            System.out.println("整体匹配:"+ matcher.group(0));
            System.out.println("协议:"+ matcher.group(1));
            System.out.println("域名:"+ matcher.group(2));
            System.out.println("端口:"+ matcher.group(3));
            System.out.println("文件:"+ matcher.group(4));
        }
        else {
            System.out.println("正则错");
        }
    }
}
