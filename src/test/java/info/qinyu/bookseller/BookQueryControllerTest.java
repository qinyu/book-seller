package info.qinyu.bookseller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static info.qinyu.bookseller.Books.DDDD;
import static info.qinyu.bookseller.Books.IDDD;
import static info.qinyu.bookseller.Books.KIA;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
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

    @ParameterizedTest(name = "查询{0}得到{1}本书")
    @MethodSource("createQueryArguments")
    void should_return_book_list_when_querying_name(String name, int expectedSize, List<Book> expectedBooks) {
        List<Book> bookList = bookQueryController.queryBookByName(name);

        assertThat(bookList).hasSize(expectedSize).containsExactlyElementsOf(expectedBooks);
    }

    private static Stream<Arguments> createQueryArguments() {
        return Stream.of(
                Arguments.of("DDD", 2, asList(IDDD, DDDD)),
                Arguments.of("Koltin", 1, singletonList(KIA)),
                Arguments.of("Spring", 0, emptyList())
        );
    }
}