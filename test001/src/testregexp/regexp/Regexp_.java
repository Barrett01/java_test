package testregexp.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
分析java的正则表达是的底层实现{重要...}
 */
public class Regexp_ {
    public static void main(String[] args) {

        String content = "1998年12月8日，第二代Java平台的企业版J2EE发布。1999年6月，Sun公司发布了\" +\n" +
                "                \"第二代Java平台（简称为Java2）的3个版本：J2ME（Java2 Micro Edition，Java2平台的微型\" +\n" +
                "                \"版），应用于移动、无线及有限资源的环境；J2SE（Java 2 Standard Edition，Java 2平台的\" +\n" +
                "                \"标准版），应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2平台的企业版），应\" +\n" +
                "                \"用3443于基于Java的应用服务器。Java 2平台的发布，是Java发展过程中最重要的一个\" +\n" +
                "                \"里程碑，标志着Java的应用开始普及9889 ";

        //匹配所有四个数字
        String regStr = "(\\d\\d)(\\d\\d)";//准确来说 这是个正则表达式
        Pattern pattern = Pattern.compile(regStr);//创建正则表达式对象
        Matcher matcher = pattern.matcher(content);//创建匹配器matcher 按照正则表达式规则去匹配content字符串
        /*
        开始匹配
         * matcher.find() 完成的任务 （考虑分组）
         * 什么是分组，比如  (\d\d)(\d\d) ,正则表达式中有() 表示分组,第1个()表示第1组,第2个()表示第2组...
         * 1. 根据指定的规则 ,定位满足规则的子字符串(比如(19)(98))
         * 2. 找到后，将 子字符串的开始的索引记录到 matcher对象的属性 int[] groups;
         *    2.1 groups[0] = 0 , 把该子字符串的结束的索引+1的值记录到 groups[1] = 4
         *    2.2 记录1组()匹配到的字符串--19 groups[2] = 0  groups[3] = 2
         *    2.3 记录2组()匹配到的字符串--98 groups[4] = 2  groups[5] = 4
         *    2.4.如果有更多的分组.....
         * 3. 同时记录oldLast 的值为 子字符串的结束的 索引+1的值即35, 即下次执行find时，就从35开始匹配
         *
         * matcher.group(0) 分析
         *
         * 源码:
         * public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         *  1. 根据 groups[0]=31 和 groups[1]=35 的记录的位置，从content开始截取子字符串返回
         *     就是 [31,35) 包含 31 但是不包含索引为 35的位置
         *
         *  如果再次指向 find方法.仍然安上面分析来执行
         */
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println("第一组（）匹配到的值="+matcher.group(1) );
            System.out.println("第二组（）匹配到的值="+matcher.group(2) );
        }
    }
}
