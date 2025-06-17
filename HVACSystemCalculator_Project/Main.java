// Main.java - Console-based HVAC System Calculator
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Map<String, Double> refrigerantPrices = new HashMap<>();
        refrigerantPrices.put("R22", 250.0);
        refrigerantPrices.put("R410a", 150.0);
        refrigerantPrices.put("R454b", 99.0);
        refrigerantPrices.put("R32", 89.0);

        Map<String, Integer> serviceCosts = new HashMap<>();
        serviceCosts.put("installation", 500);
        serviceCosts.put("repair", 200);
        serviceCosts.put("maintenance", 100);

        System.out.println("Select refrigerant type: R22, R410a, R454b, R32");
        String refrigerant = input.nextLine();

        System.out.print("Enter quantity in pounds: ");
        double pounds = input.nextDouble();
        input.nextLine(); // consume newline

        double refrigerantCost = refrigerantPrices.getOrDefault(refrigerant, 0.0) * pounds;

        System.out.println("Select service type: installation, repair, maintenance");
        String service = input.nextLine().toLowerCase();

        int serviceCost = serviceCosts.getOrDefault(service, 0);

        double total = refrigerantCost + serviceCost;

        System.out.println("--- Summary ---");
        System.out.println("Refrigerant: " + refrigerant);
        System.out.println("Quantity: " + pounds + " lbs");
        System.out.println("Refrigerant Cost: $" + refrigerantCost);
        System.out.println("Service: " + service);
        System.out.println("Service Cost: $" + serviceCost);
        System.out.println("Total Cost: $" + total);
    }
}