package coffeemachine;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coffeemachine.shoporderservice.CustomerService;
import coffeemachine.shoporderservice.OrderService;
import coffeemachine.helpers.OrderNameRegistry.OrderTypes;

public class CoffeeMachineTestSuite {

    OrderService orderService;
    CustomerService customerService;

    @BeforeEach
    public void setup() {
        orderService = new OrderService();
        customerService = new CustomerService();
        customerService.orderService = orderService; // Manually inject (since no Spring in unit tests)
    }

    // --- OrderService Tests ---

    @Test
    public void testPrepareEspressoOrder() {
        assertDoesNotThrow(() -> {
            orderService.prepareOrder("espresso");
        });
    }

    @Test
    public void testPrepareLatteOrder() {
        assertDoesNotThrow(() -> {
            orderService.prepareOrder("latte");
        });
    }

    @Test
    public void testPrepareCappucinoOrder() {
        assertDoesNotThrow(() -> {
            orderService.prepareOrder("cappucino");
        });
    }

    @Test
    public void testPrepareInvalidOrderThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            orderService.prepareOrder("invalid_order");
        });
        assertTrue(exception.getMessage().contains("Unknown order type"));
    }

    // --- CustomerService Tests ---

    @Test
    public void testCustomerServiceCreatesValidOrder() {
        String[] args = {"TestCustomer", "espresso"};
        assertDoesNotThrow(() -> {
            customerService.createOrder(args);
        });
    }

    @Test
    public void testCustomerServiceHandlesInvalidOrder() {
        String[] args = {"TestCustomer", "invalid_order"};
        assertDoesNotThrow(() -> {
            customerService.createOrder(args);
        });
    }

    @Test
    public void testCustomerServiceBulkOrders() {
        String[] customers = {"Alice", "Bob", "Charlie"};
        String[] orders = {"espresso", "latte", "cappucino"};

        List<String> results = customerService.placeOrderTest(orders, customers);

        assertEquals(3, results.size());
        assertTrue(results.get(0).contains("[LOG] Order Completed!"));
        assertTrue(results.get(1).contains("[LOG] Order Completed!"));
        assertTrue(results.get(2).contains("[LOG] Order Completed!"));
    }

    // --- Enum Tests ---

    @Test
    public void testOrderTypesFromString() {
        assertEquals(OrderTypes.ESPRESSO, OrderTypes.fromString("espresso"));
        assertEquals(OrderTypes.LATTE, OrderTypes.fromString("LATTE")); // Case insensitive
        assertEquals(OrderTypes.CAPPUCINO, OrderTypes.fromString("Cappucino"));
    }

    @Test
    public void testOrderTypesFromStringInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            OrderTypes.fromString("mocha");
        });
    }
}
