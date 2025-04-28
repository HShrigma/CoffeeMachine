package coffeemachine.shoporderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import coffeemachine.CoffeeMachine;
import coffeemachine.helpers.OrderNameRegistry.OrderTypes;

@Component
public class OrderService {
    @Autowired
    CoffeeMachine machine;
    @Autowired
    MilkSteamer steamer;

    void processOrderOfType(OrderTypes type) {
        switch (type) {
            case ESPRESSO:
                machine.brew();
                break;
            case LATTE:
            case CAPPUCINO:
                steamer.steam();
                machine.brew();
                break;
            default:
                System.err.printf("[ERROR] Cannot process order of type: %s\n", type.label());
                return;
        }
        System.out.printf("Thank you for getting our delicious %s!\n", type.label());
    }

    // Public Endpoint
    public void prepareOrder(String order) {
        processOrderOfType(OrderTypes.fromString(order));
    }
}