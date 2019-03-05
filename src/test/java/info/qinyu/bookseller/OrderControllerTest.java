package info.qinyu.bookseller;

import org.junit.jupiter.api.Test;

import static info.qinyu.bookseller.Books.IDDD;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderControllerTest {

    @Test
    void should_create_order_when_adding_one_book(){
        OrderController orderController = new OrderController();

        Order order = orderController.createOrder(IDDD);

        assertThat(order).hasFieldOrPropertyWithValue("price", 99.00d);
    }
}
