package coffeemachine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Start Spring Core - create IoC container
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppRunner application = context.getBean(AppRunner.class);
        
        application.RunApp();

        ((AnnotationConfigApplicationContext) context).close();

    }
}