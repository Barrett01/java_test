package TestChangYongLei;
//通过断点来观察底层原来是如何处理的
public class StringBuffer02 {
    public static void main(String[] args) {
        //1，会创建一个大小为16的char [],用于存放字符内容
        StringBuffer stringBuffer = new StringBuffer();

        //2，通过构造器指定char[] 的大小
        StringBuffer stringBuffer1 = new StringBuffer(100);
        //通过给一个String创建StringBuffer,char[] 大小就是 str.length()+16
        StringBuffer stringBuffer2 = new StringBuffer("zhangsan");

    }
}
