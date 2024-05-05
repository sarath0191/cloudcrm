class Store {
    private String storeName; private double totalSales;
    public Store(String storeName) { this.storeName = storeName; this.totalSales = 0.0;
    }
    public String getStoreName() { return storeName;
    }
    public double getTotalSales() { return totalSales;
    }
    public void recordSale(double amount) { totalSales += amount;
    }
    public double calculateThreshold() {
    // Implement your threshold calculation logic here
    // For example, you can calculate the threshold based on a percentage of total sales.

    double thresholdPercentage = 0.10; // 10% threshold
    return totalSales * thresholdPercentage; }
    }
    public class StoreThresholdCalculation { public static void main(String[] args) {
    // Create a store named "Store 6" Store store6 = new Store("Store 6");
    // Simulate recording sales store6.recordSale(5000.0); store6.recordSale(7000.0); store6.recordSale(8000.0);
    // Calculate and display the threshold for "Store 6"
    double threshold = store6.calculateThreshold();
    System.out.println("Threshold for " + store6.getStoreName() + ": $" + threshold);
    } }