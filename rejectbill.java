class Bill {
    private String billNumber; private double amount; private boolean isRejected;
    public Bill(String billNumber, double amount) { this.billNumber = billNumber;
    this.amount = amount;
    this.isRejected = false;
    }
    public String getBillNumber() { return billNumber;
    }
    public double getAmount() { return amount;
    }
    public boolean isRejected() { return isRejected;
    }
    public void reject() {

             isRejected = true; }
    }
    class Retailer {
    private String name;
    public Retailer(String name) { this.name = name;
    }
    public void rejectBill(Bill bill) {
    bill.reject();
    System.out.println("Bill " + bill.getBillNumber() + " has been rejected by " + name);
    } }
    public class RetailSystem {
    public static void main(String[] args) {
    // Create a retailer
    Retailer retailer = new Retailer("ABC Retailer");
    // Create a bill
    Bill bill = new Bill("B123", 100.0);
    
       
    // Simulate bill rejection retailer.rejectBill(bill);
    if (bill.isRejected()) {
    System.out.println("The bill has been rejected.");
    } else {
    System.out.println("The bill is pending.");
    } }
    }