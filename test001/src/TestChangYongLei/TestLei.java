package TestChangYongLei;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

public class TestLei {
    //常用类的练习
    public static void main(String[] args) {

        //返回当前时间距离1970-1-1的毫秒数
        System.out.println(System.currentTimeMillis());
        System.out.println("----------------------");
        unpacking unpacking = new unpacking();
        boolean b = unpacking.PanDuan(1, 1);
        System.out.println(b);


        //时间类的练习
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss E");
        String format = dateTimeFormatter.format(now);
        System.out.println(format);

        LocalDate now1 = LocalDate.now();
        System.out.println("获取年月日："+ now1);
        LocalTime now2 = LocalTime.now();
        System.out.println("获得时分秒："+ now2);

        //查看450天后，是什么时候
        LocalDateTime localDateTime1 = now.plusDays(450);
        String afterTime = dateTimeFormatter.format(localDateTime1);
        System.out.println(afterTime);

        //查看30000分钟之前的日期
        LocalDateTime localDateTime2 = now.minusMinutes(30000);
        String beforeTime = dateTimeFormatter.format(localDateTime2);
        System.out.println(beforeTime);

        //时间戳
        Instant now3 = Instant.now();
        System.out.println(now3);
        Date from = Date.from(now3);
        System.out.println(from);
        Instant instant = from.toInstant();
        System.out.println(instant);


        // Integer类和Character类的常用方法
        System.out.println(Integer.MAX_VALUE);

        //StringBuffer 与 String的转换



        //StringBuffer常用方法的使用

        //StringBuffer 类练习


        //String StringBuffer StringBuilder

        //Arrays类的应用案例，配合视频看看，代码部分不是太懂


        List asList = Arrays.asList(2,3,4,5,6,1);
        System.out.println("asList=" + asList);
        System.out.println("asList的运行类型" + asList.getClass());
    }
}

class unpacking {
    /*
    拆箱装箱的一个演示 Integer的一个底层范围是-127~128
    Integer m = 1;
    Integer m1 = 1;
    Integer k = 128;
    Integer k1 = 128;
     */
    public boolean PanDuan(Integer a, Integer b) {
//       return a.equals(b);
        if (a != b) {
            return false;
        }
        return true;
    }
}

//字符串特性
class Test{
    String str = new String("hsp");
    final char[] ch = {'j','a','v','a'};
    public void change(String str,char ch[]){
        str = "java";//首先这个str是创建于数据池中，其次他只作用于““局部中””
        ch[0] = 'h';//直接吧堆中的“java”进行修改
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.str);
        System.out.println(test.ch);
        System.out.println("====================");
        test.change(test.str,test.ch);//调用方法 产生新栈
        System.out.println(test.str);
        System.out.println(test.ch);
    }


}
