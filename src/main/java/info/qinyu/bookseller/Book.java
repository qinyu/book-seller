package info.qinyu.bookseller;

import java.util.Objects;

public class Book {
    private final String name;
    private final String author;
    private final String price;

    public Book(String name, String author, String price) {

        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, price);
    }
}
