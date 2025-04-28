package coffeemachine.helpers;

public class OrderNameRegistry {
    public enum OrderTypes {
        espresso,
        latte,
        cappucino
    }

    public final String espressoReg = "espresso";
    public final String latteReg = "latte";
    public final String cappucinoReg = "cappucino";

    public String orderEnumToString(OrderTypes type) {
        switch (type) {
            case espresso:
                return espressoReg;
            case latte:
                return latteReg;
            case cappucino:
                return cappucinoReg;
            default:
                System.err.printf("[ERROR] Unkown order type: %s\n", type.toString());
                return null;
        }
    }

    public OrderTypes orderStringToEnum(String reg) {
        switch (reg.toLowerCase()) {
            case espressoReg:
                return OrderTypes.espresso;
            case latteReg:
                return OrderTypes.latte;
            case cappucinoReg:
                return OrderTypes.cappucino;
            default:
                System.err.printf("[ERROR] Unkown order registry string: %s\n", reg);
                return null;
        }
    }
}