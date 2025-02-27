package TestChangYongLei;
//StringBuffer的练习1
public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//看源码，底层调用AbstractStringBuilder的appendNUll
        System.out.println(sb.length());

        StringBuffer stringBuffer = new StringBuffer(str);//看底层源码super（str.length()+16）
        System.out.println(stringBuffer.length());
    }
}
