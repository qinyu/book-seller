package info.qinyu.bookseller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class BookQueryController {

    private final BookRepository bookRepository;

    public BookQueryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/query")
    public List<Book> queryBookByName(@RequestParam("name") String name){
        return bookRepository.findByName(name);
    }
}
