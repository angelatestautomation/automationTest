package Utils;

public class Warning {
    public static void print(boolean condition, String warningMessage){
        if (condition == false){
            System.out.println(warningMessage);
        }
    }
}
