package info.qinyu.bookseller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookQueryController {

    @GetMapping("/query")
    public Book queryBookByName(@RequestParam("name") String name){
        return new Book("Kotlin in Action", "qinyu", "89.00");
    }
}
