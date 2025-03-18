package TestJiHe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
注意：集合这章不太难，主要是源码，跟进去好好练习源码！
 */
public class CollectionTterator {
    public static void main(String[] args) {
        Collection   col = new ArrayList();
        col.add(new Book("三国","罗贯中",10.1));
        col.add(new Book("小李飞刀","古龙",5.1));
        col.add(new Book("红楼梦","曹雪芹",34.6));
        System.out.println(col);
        //遍历
        System.out.println("==========================");
        Iterator iterator = col.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println("obj:"+next);
        }
        //当推出while循环的时候，这是iterator迭代器，指向最后的元素
        //如果要再次遍历，需要我们重置{再次 col.iterator()}我们的迭代器
    }
}
class Book{
   private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return name + "\t" + author + "\t" + price + "\n";
    }
}
