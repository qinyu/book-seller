package info.qinyu.bookseller;


public class OrderController {

    public Order createOrder(Book book) {
        Order order = new Order();
        order.add(book);
        return order;
    }

}
