package TestChangYongLei;
//String 和StringBuffer的相互转换
public class StringAndStringBuffer {
    public static void main(String[] args) {
        //String -> StringBuffer
        //第一种，使用构造器
        String str = "xiaohh";
        StringBuffer stringBuffer = new StringBuffer(str);
        //第二种 使用append方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1.append(str);

        //StringBuffer -> String
        //第一种使用构造器
        StringBuffer stringBuffer2 = new StringBuffer("xiao黄豪");
        String s = new String(stringBuffer2);

        //第二种使用toString方法
        String sm = stringBuffer2.toString();

    }
}
