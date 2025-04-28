package coffeemachine;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import coffeemachine.shoporderservice.CustomerService;

@Component
public class AppRunner {
    @Autowired
    CustomerService service;

    void processCommands(Scanner s){
        String command = "";
        // Pattern: one or more non-space chars, space, one or more non-space chars
        Pattern orderPattern = Pattern.compile("^\\S+\\s\\S+$");

        do {
            System.out.println("Please place an order as such: <Your Customer Name> *SPACE* <Your Order Name>");
            System.out.println("Or type 'EXIT' to quit");
            command = s.nextLine();

            if (command.equals("EXIT")) {
                continue;
            }

            if (orderPattern.matcher(command).matches()) {
                service.createOrder(command.split(" "));
            } else {
                System.out.println("Invalid format! Please enter as: <CustomerName> <OrderName>");
                System.out.println("Example: John latte");
            }

        } while (!command.equals("EXIT"));
    }
    
    public void RunApp() {
        Scanner s = new Scanner(System.in);

        processCommands(s);

        System.out.println("Thank you for using our service!");
        s.close();
    }
}