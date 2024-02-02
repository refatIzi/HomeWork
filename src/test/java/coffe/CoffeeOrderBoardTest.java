package coffe;

import org.example.coffe.order.CoffeeOrderBoard;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CoffeeOrderBoardTest {


    @Test
    public void testAddOrder() {
        System.out.println("Run test Add Order");
        CoffeeOrderBoard board1 = new CoffeeOrderBoard();

        board1.add("Latte");
        board1.add("Cappuccino");

        assertEquals(2, board1.orders.size());
        assertEquals("Latte", board1.orders.get(0).getName());
        assertEquals("Cappuccino", board1.orders.get(1).getName());
    }

    @Test
    public void testDeliverFirstOrder() {
        System.out.println("Run test Deliver First Order");

        CoffeeOrderBoard board2 = new CoffeeOrderBoard();

        board2.add("Espresso");
        board2.add("Americano");

        board2.deliver();

        assertEquals(1, board2.orders.size());
        assertEquals("Americano", board2.orders.get(0).getName());
    }

    @Test
    public void testDeliverSpecificOrder() {
        System.out.println("Run test Deliver Specific Order");

        CoffeeOrderBoard board3 = new CoffeeOrderBoard();

        board3.add("Latte");
        board3.add("Mocha");
        board3.add("Cappuccino");

        board3.deliver(2);

        assertEquals(2, board3.orders.size());
        assertEquals("Latte", board3.orders.get(0).getName());
        assertEquals("Cappuccino", board3.orders.get(1).getName());
    }

    @Test
    public void testDrawOrders() {
        System.out.println("Run test Draw Orders");

        CoffeeOrderBoard board4 = new CoffeeOrderBoard();
        board4.add("Latte");
        board4.add("Americano");
        System.out.println(board4.draw());
        String expectedOutput = "Num  |  Name\n" +
                "4  |  Latte\n" +
                "5  |  Americano\n";
        assertEquals(expectedOutput, board4.draw());
    }

}
