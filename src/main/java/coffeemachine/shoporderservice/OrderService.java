package coffeemachine.shoporderservice;

import coffeemachine.AppConfig;
import coffeemachine.CoffeeMachine;
import coffeemachine.helpers.*;
import coffeemachine.helpers.OrderNameRegistry.OrderTypes;

public class OrderService {
    // Fields
    AppConfig config;
    OrderNameRegistry nameRegistry;
    CoffeeMachine machine;
    MilkSteamer steamer;
    // Constructor
    public OrderService(AppConfig config){
        this.config = config;
        machine = config.coffeeMachine();
        steamer = config.milkSteamer();
        nameRegistry = config.registry();
    }

    // Private functions
    OrderTypes getOrderType(String input) {
        return nameRegistry.orderStringToEnum(input);
    }

    void processOrderOfType(OrderTypes type) {
        switch (type) {
            case espresso:
                machine.brew();
                break;
            case latte:
            case cappucino:
                steamer.steam();
                machine.brew();
                break;
            default:
                System.err.printf("[ERROR] Cannot process order of type: %s\n", type.toString());
                return;
        }
        System.out.printf("Thank you for getting our delicious %s!\n", nameRegistry.orderEnumToString(type));
    }

    // Public Endpoint
    public void prepareOrder(String order) {
        processOrderOfType(getOrderType(order));
    }
}