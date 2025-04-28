package coffeemachine;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AppRunner {
    AppConfig config;
    public AppRunner(AppConfig config){
        this.config = config;
    }
    public void RunApp() {
        Scanner s = new Scanner(System.in);
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
                config.customerService().createOrder(command.split(" "));
            } else {
                System.out.println("Invalid format! Please enter as: <CustomerName> <OrderName>");
                System.out.println("Example: John latte");
            }

        } while (!command.equals("EXIT"));

        System.out.println("Thank you for using our service!");
        s.close();
    }
}