package info.qinyu.bookseller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static info.qinyu.bookseller.Books.*;
import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("使用了Mock的BookQueryController单元测试")
class BookQueryControllerTest {

    private BookQueryController bookQueryController;

    @BeforeEach
    void setUp() {
        BookRepository bookRepository = mock(BookRepository.class);
        given(bookRepository.findByName("DDD")).willReturn(asList(IDDD, DDDD));
        given(bookRepository.findByName("Koltin")).willReturn(singletonList(KIA));
        given(bookRepository.findByName("Spring")).willReturn(emptyList());
        bookQueryController = new BookQueryController(bookRepository);
    }

    @Test
    @DisplayName("查到了两本DDD")
    void should_return_book_list_when_querying_book() {

        List<Book> bookList = bookQueryController.queryBookByName("DDD");

        assertThat(bookList).hasSize(2).contains(IDDD, DDDD);
    }

    @Test
    @DisplayName("查到了一本DDD")
    void should_return_book_list_when_querying_return_only_one_book() {

        List<Book> bookList = bookQueryController.queryBookByName("Koltin");

        assertThat(bookList).hasSize(1).contains(KIA);
    }

    @Test
    @DisplayName("没有查到")
    void should_return_empty_list_when_querying_not_existing_book() {

        List<Book> bookList = bookQueryController.queryBookByName("Spring");

        assertThat(bookList).hasSize(0);
    }

}