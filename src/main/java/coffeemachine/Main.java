package coffeemachine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Start Spring Core - create IoC container
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CoffeeMachine machine = context.getBean(CoffeeMachine.class);

        // Use it
        machine.brew();

        ((AnnotationConfigApplicationContext) context).close();

    }
}