package info.qinyu.bookseller;

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
}
