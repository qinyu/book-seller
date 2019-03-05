package info.qinyu.bookseller;

import java.util.List;

public interface BookRepository {
    List<Book> findByName(String name);
}
