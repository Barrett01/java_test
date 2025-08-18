package testregexp.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
经典 哑巴学英语
 */
public class ReExp12 {

    public static void main(String[] args) {
        String content = "我...我要...学学学...学编程java";
        //去掉.
        Pattern compile = Pattern.compile("\\.");
        Matcher matcher = compile.matcher(content);
        content = matcher.replaceAll("");

        //找到相等的叠词 替换掉
        Pattern compile1 = Pattern.compile("(.)\\1+");
        Matcher matcher1 = compile1.matcher(content);
       content =  matcher1.replaceAll("$1");
        System.out.println(content);


    }
}
