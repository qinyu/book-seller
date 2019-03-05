package info.qinyu.bookseller;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static info.qinyu.bookseller.Books.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class BookQueryControllerTest {

    @Test
    void should_return_book_list_when_querying_book() {
        BookRepository bookRepository = mock(BookRepository.class);
        given(bookRepository.findByName("DDD")).willReturn(asList(IDDD, DDDD));

        BookQueryController controller = new BookQueryController(bookRepository);
        List<Book> bookList = controller.queryBookByName("DDD");

        assertThat(bookList).hasSize(2).contains(IDDD, DDDD);
    }

    @Test
    void should_return_book_list_when_querying_return_only_one_book() {
        BookRepository bookRepository = mock(BookRepository.class);
        given(bookRepository.findByName("Koltin")).willReturn(Collections.singletonList(KIA));

        BookQueryController controller = new BookQueryController(bookRepository);
        List<Book> bookList = controller.queryBookByName("Koltin");

        assertThat(bookList).hasSize(1).contains(KIA);
    }

    @Test
    void should_return_empty_list_when_querying_not_existing_book() {
        BookRepository bookRepository = mock(BookRepository.class);
        given(bookRepository.findByName("Spring")).willReturn(Collections.emptyList());

        BookQueryController controller = new BookQueryController(bookRepository);
        List<Book> bookList = controller.queryBookByName("Koltin");

        assertThat(bookList).hasSize(0);
    }

}