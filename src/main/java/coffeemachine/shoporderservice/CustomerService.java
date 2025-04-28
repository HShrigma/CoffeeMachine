package coffeemachine.shoporderservice;

import coffeemachine.AppConfig;

public class CustomerService {
    // Fields
    OrderService orderService;
    AppConfig config;

    // Constructor
    public CustomerService(AppConfig config) {
        this.config = config;
        orderService = this.config.orderService();
    }

    // Endpoint
    public void createOrder(String[] args) {
        String customer = args[0];
        String order = args[1];

        System.out.printf("[LOG] New Order for customer %s!\n", customer);
        try{
            orderService.prepareOrder(order);
        }
        catch(Exception e){
            System.err.println("[ERROR] an error occured preparing your order:");
            e.printStackTrace();
        }
        finally{
            System.out.println("[LOG] Order Completed!");
        }
    }

    // Testing void
    public void placeOrderTest() {
        String[] orders = new String[] { 
            config.registry().espressoReg, 
            config.registry().latteReg,
            config.registry().cappucinoReg, "junkOrderForErrorTesting" };
        for (String order : orders) {
            createOrder(new String[] { "TestCustomer", order });            
        }
    }
}