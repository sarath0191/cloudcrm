class Store {
    private String storeName; private double totalSales;
    private double inStoreThreshold;
    public Store(String storeName, double inStoreThreshold) { this.storeName = storeName;
    this.totalSales = 0.0;
    this.inStoreThreshold = inStoreThreshold;
    }
    public String getStoreName() { return storeName;
    }
    public double getTotalSales() { return totalSales;
    }
    public void recordSale(double amount) { totalSales += amount;
    }
    public boolean isAboveInStoreThreshold() {

    return totalSales >= inStoreThreshold; }
    }
    public class InStoreThresholdCalculation { public static void main(String[] args) {
    // Create a store named "Store 6" with a fixed in-store threshold of $10,000 Store store6 = new Store("Store 6", 10000.0);
    // Simulate recording in-store sales store6.recordSale(5000.0); store6.recordSale(7000.0);
    // Check if the store is above the in-store threshold
    boolean aboveThreshold = store6.isAboveInStoreThreshold();
    System.out.println("Total Sales for " + store6.getStoreName() + ": $" + store6.getTotalSales());
    if (aboveThreshold) {
    System.out.println(store6.getStoreName() + " is above the in-store threshold.");
    } else {
    System.out.println(store6.getStoreName() + " is below the in-store threshold.");
    } }
    }