package TestChangYongLei;

// 对Arrays的一个练习{课堂作业}
import java.util.Arrays;
import java.util.Comparator;

public class ArraysExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("新红楼梦", 45);
        books[1] = new Book("水浒传精装版", 88);
        books[2] = new Book("新西游记", 55);
        books[3] = new Book("三国志", 66);

        //这个是sort的原理
        bubbleSort01(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 =  (Integer)(o1);
                int i2 = (Integer)( o2);
                return i2-i1;
            }
        });
        System.out.println(Arrays.toString(books));

        //真正用起来用这个：
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                Book b1 = (Book)o1;
                Book b2 = (Book)o2;
                double priceval = b2.getPrice()-b1.getPrice();
                if(priceval<0){
                    return 1;
                } else if (priceval>0) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(books));

        //或者用书名的字数
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                Book b1 = (Book)o1;
                Book b2 = (Book)o2;
                return b2.getTitle().length()-b1.getTitle().length();
                //或者像价格那样去接受也行

            }
        });
        System.out.println("============根据书名的长度=========");
        System.out.println(Arrays.toString(books));
    }
    public static void bubbleSort01(Book[] books, Comparator c) {
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - i - 1; j++) {
                if (c.compare(books[j].getPrice(), books[j + 1].getPrice()) > 0) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }
}

class Book{
    private String title;
    private int price;

    public Book() {
    }
    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", price=" + price + "]\n";
    }
}
