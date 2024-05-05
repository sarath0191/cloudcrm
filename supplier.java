import java.util.HashMap; import java.util.Map; import java.util.Scanner;
class Supplier {
private String name; private String description;
public Supplier(String name, String description) { this.name = name;
this.description = description;
}
public String getName() { return name;
}
public String getDescription() { return description;
} }
class SuperUser {
private String username;

         private String password;
private Map<String, Supplier> supplierControl = new HashMap<>();
public SuperUser(String username, String password) { this.username = username;
this.password = password;
}
public String getUsername() { return username;
}
public String getPassword() { return password;
}
public void addSupplierControl(String supplierName, String description) { supplierControl.put(supplierName, new Supplier(supplierName, description));
}
public void removeSupplierControl(String supplierName) { supplierControl.remove(supplierName);
}
public void listSupplierControl() {

   
         System.out.println("Supplier Control List:");
for (Supplier supplier : supplierControl.values()) {
System.out.println("Name: " + supplier.getName()); System.out.println("Description: " + supplier.getDescription()); System.out.println();
} }
}
public class SuperUserControlSupplierSystem { public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Create a super user
SuperUser superUser = new SuperUser("superuser", "super123");
// Simulate login System.out.print("Username: ");
String usernameInput = scanner.nextLine(); System.out.print("Password: ");
String passwordInput = scanner.nextLine();
if (superUser.getUsername().equals(usernameInput) && superUser.getPassword().equals(passwordInput)) {
System.out.println("Logged in as Super User");

   
         System.out.println();
// Super User Control Over Supplier while (true) {
System.out.println("1. Add Supplier Control"); System.out.println("2. Remove Supplier Control"); System.out.println("3. List Supplier Control"); System.out.println("4. Exit"); System.out.print("Enter your choice: ");
int choice = scanner.nextInt();
scanner.nextLine(); // Consume the newline
switch (choice) { case 1:
System.out.print("Enter Supplier Name: ");
String supplierName = scanner.nextLine();
System.out.print("Enter Supplier Description: ");
String supplierDescription = scanner.nextLine(); superUser.addSupplierControl(supplierName, supplierDescription); break;
case 2:
System.out.print("Enter Supplier Name to Remove: "); String supplierToRemove = scanner.nextLine(); superUser.removeSupplierControl(supplierToRemove);
   
break; case 3:
superUser.listSupplierControl();
break; case 4:
System.out.println("Exiting..."); scanner.close();
System.exit(0);
break;
default:
System.out.println("Invalid choice. Please try again.");
} }
} else {
System.out.println("Authentication failed.");
} }
}