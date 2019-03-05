package info.qinyu.bookseller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Order {

    private List<Book> books;

    public Order() {
        books = new ArrayList<>();
    }

    public void add(Book book) {
        books.add(book);
    }

    public Double getPrice() {
        return books.stream().mapToDouble(b -> Double.parseDouble(b.getPrice())).sum();
    }

}
