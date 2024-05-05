import java.util.HashMap; import java.util.Map; import java.util.Scanner;
class Department {
private String name; private String description;
public Department(String name, String description) { this.name = name;
this.description = description;
}
public String getName() { return name;
}
public String getDescription() { return description;
} }
class SuperUser {
private String username;

         private String password;
private Map<String, Department> departmentControl = new HashMap<>();
public SuperUser(String username, String password) { this.username = username;
this.password = password;
}
public String getUsername() { return username;
}
public String getPassword() { return password;
}
public void addDepartmentControl(String departmentName, String description) {
departmentControl.put(departmentName, new Department(departmentName, description));
}
public void removeDepartmentControl(String departmentName) { departmentControl.remove(departmentName);
}

   
         public void listDepartmentControl() { System.out.println("Department Control List:");
for (Department department : departmentControl.values()) {
System.out.println("Name: " + department.getName()); System.out.println("Description: " + department.getDescription()); System.out.println();
} }
}
public class SuperUserControlSystem { public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Create a super user
SuperUser superUser = new SuperUser("superuser", "super123");
// Simulate login System.out.print("Username: ");
String usernameInput = scanner.nextLine(); System.out.print("Password: ");
String passwordInput = scanner.nextLine();
if (superUser.getUsername().equals(usernameInput) && superUser.getPassword().equals(passwordInput)) {

   
         System.out.println("Logged in as Super User"); System.out.println();
// Super User Control Over Department Control while (true) {
System.out.println("1. Add Department Control"); System.out.println("2. Remove Department Control"); System.out.println("3. List Department Control"); System.out.println("4. Exit");
System.out.print("Enter your choice: "); int choice = scanner.nextInt();
scanner.nextLine(); // Consume the newline
switch (choice) { case 1:
System.out.print("Enter Department Name: ");
String departmentName = scanner.nextLine();
System.out.print("Enter Department Description: ");
String departmentDescription = scanner.nextLine(); superUser.addDepartmentControl(departmentName, departmentDescription); break;
case 2:
System.out.print("Enter Department Name to Remove: "); String departmentToRemove = scanner.nextLine();

   
superUser.removeDepartmentControl(departmentToRemove);
break; case 3:
superUser.listDepartmentControl();
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