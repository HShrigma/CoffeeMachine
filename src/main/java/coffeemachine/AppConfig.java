package coffeemachine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import coffeemachine.helpers.OrderNameRegistry;
import coffeemachine.shoporderservice.*;

@Configuration
public class AppConfig {

    @Bean
    public CoffeeMachine coffeeMachine() {
        return new CoffeeMachine();
    }

    @Bean
    public MilkSteamer milkSteamer() {
        return new MilkSteamer();
    }

    @Bean
    public OrderNameRegistry registry() {
        return new OrderNameRegistry();
    }

    @Bean
    public OrderService orderService() {
        return new OrderService(this);
    }

    @Bean
    CustomerService customerService() {
        return new CustomerService(this);
    }

    @Bean
    AppRunner appRunner() {
        return new AppRunner(this);
    }
}