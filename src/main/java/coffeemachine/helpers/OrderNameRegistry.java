package coffeemachine.helpers;

public class OrderNameRegistry {
    public enum OrderTypes {
        ESPRESSO("espresso"),
        LATTE("latte"),
        CAPPUCINO("cappucino");
    
        private final String label;
    
        OrderTypes(String label) {
            this.label = label;
        }
    
        public String label() {
            return label;
        }
    
        public static OrderTypes fromString(String input) {
            for (OrderTypes type : values()) {
                if (type.label.equalsIgnoreCase(input)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown order type: " + input);
        }
    }
}