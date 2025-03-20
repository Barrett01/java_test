package TestJiHe;

import java.util.ArrayList;
import java.util.Iterator;

//练习List方法:冒泡排序之交换对象
/*
按价格排序
要求使用ArrayList LinkedList Vector三种集合
 */
public class ListExercise02 {
    public static void main(String[] args) {
        LBBook book1 = new LBBook("红楼梦","曹雪芹",100);
        LBBook book2 = new LBBook("西游记","吴承恩",10);
        LBBook book3 = new LBBook("水浒传","施耐庵",19);
        LBBook book4 = new LBBook("三国演义","罗贯中",80);
        LBBook book5 = new LBBook("西厢记","匿名者",10);
//        System.out.println(book);
        ArrayList lbBooks = new ArrayList<>();
        lbBooks.add(book1);
        lbBooks.add(book2);
        lbBooks.add(book3);
        lbBooks.add(book4);
        lbBooks.add(book5);
        ppxu(lbBooks);
        Iterator iterator = lbBooks.iterator();
        while (iterator.hasNext()) {
            LBBook lbBook = (LBBook) iterator.next();
            System.out.println(lbBook);
        }


    }
    public static void ppxu(ArrayList<LBBook> list){
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() -1-i; j++) {
                if (list.get(j).getPrice() > list.get(j+1).getPrice()){
                    LBBook temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }
}
class LBBook{
    private String title;
    private String author;
    private double price;

    public LBBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LBBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}