package selenium_java;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GroceryBillingSystem {

    static class Item {
    	
    	  private int price;
    	  private int stock;

    	    // Required by Jackson
    	    public Item() {
    	    }

    	    public Item(int price, int stock) {
    	        this.price = price;
    	        this.stock = stock;
    	    }

    	    public int getPrice() {
    	        return price;
    	    }

    	    public int getStock() {
    	        return stock;
    	    }
    }

    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        Map<String, Item> inventory = new HashMap<>();
        inventory.put("apple", new Item(3, 50));
        inventory.put("banana", new Item(1, 100));
        inventory.put("milk", new Item(5, 20));
        inventory.put("bread", new Item(2, 30));

        Map<String, Integer> order = new HashMap<>();
        order.put("apple", 4);
        order.put("milk", 2);

        printOrderAsJson(order);
        generateBill(inventory, order);
        printInventoryAsJson(inventory);
    }

    // Print order JSON
    public static void printOrderAsJson(Map<String, Integer> order) throws Exception {
        System.out.println("Inventory Order:");
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(order));
    }

    public static boolean itemExists(String itemName, Map<String, Item> inventory) {
        return inventory.containsKey(itemName);
    }

    public static boolean enoughStocks(String itemName, Map<String, Item> inventory, int quantity) {
        return inventory.get(itemName).stock >= quantity;
    }

    public static int calculateCost(String itemName, Map<String, Item> inventory, int quantity) {
        return inventory.get(itemName).price * quantity;
    }

    public static void updateInventory(String itemName, Map<String, Item> inventory, int quantity) {
        inventory.get(itemName).stock -= quantity;
    }

    public static void generateBill(Map<String, Item> inventory, Map<String, Integer> order) {

        int totalAmount = 0;

        // Validation
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();

            if (!itemExists(item, inventory)) {
                System.out.println("Item not found: " + item);
                return;
            }

            if (!enoughStocks(item, inventory, quantity)) {
                System.out.println("Insufficient stock for: " + item);
                return;
            }
        }

        System.out.println("\nItem\tQty\tPrice\tTotal");
        System.out.println("-------------------------------");

        // Billing + inventory update
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();

            int cost = calculateCost(item, inventory, quantity);
            totalAmount += cost;

            System.out.println(item + "\t" + quantity + "\t" +
                    inventory.get(item).price + "\t" + cost);

            updateInventory(item, inventory, quantity);
        }

        System.out.println("-------------------------------");
        System.out.println("\nGrand Total: " + totalAmount);
    }

    // Print inventory JSON
    public static void printInventoryAsJson(Map<String, Item> inventory) throws Exception {
        System.out.println("\nUpdated Inventory:");
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(inventory));
    }
}

