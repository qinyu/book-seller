package info.qinyu.bookseller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static info.qinyu.bookseller.Books.DDDD;
import static info.qinyu.bookseller.Books.IDDD;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @ParameterizedTest
    @MethodSource("createBookOrderArguments")
    void should_sum_all_books_price(List<Book> books, double totalPrice) {
        books.stream().forEach(b -> order.add(b));

        assertThat(order.getPrice()).isCloseTo(totalPrice, offset(0.0001d));
    }

    private static Stream<Arguments> createBookOrderArguments() {
        return Stream.of(
                Arguments.of(singletonList(IDDD), 99.00d),
                Arguments.of(asList(IDDD, DDDD), 164.00d),
                Arguments.of(asList(IDDD, IDDD, DDDD, DDDD), 328.00d)
        );
    }
}