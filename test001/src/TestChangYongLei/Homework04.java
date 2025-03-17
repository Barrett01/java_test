package TestChangYongLei;

public class Homework04 {
    public static void main(String[] args) {
    String str = "haunghao8866993322HUANGHAO.66";
    countString(str);
    }
    public static void countString(String str) {
        int Xcount = 0;
        int Dcount = 0;
        int count = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if ('0' <= c && c<= '9' ){
                count++;
            } else if ('a'<=c && c<='z') {
                Xcount++;
            } else if ('A'<=c && c<='Z') {
                Dcount++;
            }
        }

        String format = String.format("数字共出现%d,小写字母共出现%d,大写字母共出现%d;", count, Xcount, Dcount);
        System.out.println(format);
    }
}
