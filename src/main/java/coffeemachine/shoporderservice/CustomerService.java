package coffeemachine.shoporderservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
    // Fields
    @Autowired
    public OrderService orderService;
    // Private methods
    String processCustomerOrder(String[] args) {
        String customer = args[0];
        String order = args[1];

        System.out.printf("[LOG] New Order for customer %s!\n", customer);
        String res = "";
        try {
            orderService.prepareOrder(order);
            res = "[LOG] Order Completed!";
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res = "[ERROR] an error occured preparing your order:";
            return res;
        }
    }

    // Endpoint

    public void createOrder(String[] args) {
        System.out.println(processCustomerOrder(args));
    }

    // Testing String
    public List<String> placeOrderTest(String[] orders, String[] customers) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            String[] args = new String[] { customers[i], orders[i] };
            res.add(processCustomerOrder(args));
        }
        return res;
    }
}