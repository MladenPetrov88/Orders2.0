import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Double> orders = new LinkedHashMap<>();
        Map<String, Double> rememberProducts = new LinkedHashMap<>();

        while (!command.equals("buy")) {
            String[] temp = command.split(" ");
            String product = temp[0];
            double price = Double.parseDouble(temp[1]);
            double quantity = Double.parseDouble(temp[2]);


            if (!orders.containsKey(product)) {
                orders.put(product, quantity * price);
                rememberProducts.put(product, quantity);
            } else {
                rememberProducts.put(product, rememberProducts.get(product) + quantity);
                orders.put(product, rememberProducts.get(product) * price);
            }

            command = scanner.nextLine();
        }

        orders.forEach((k, v) -> System.out.println(String.format("%s -> %.2f", k, v)));


    }
}
