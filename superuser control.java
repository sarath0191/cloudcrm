import java.util.HashMap; import java.util.Map; import java.util.Scanner;
class User {
private String username; private String password; private String role;
public User(String username, String password, String role) { this.username = username;
this.password = password;
this.role = role;
}
public String getUsername() { return username;
}
public String getPassword() { return password;
}
public String getRole() {

         return role; }
}
class SuperUser {
private String username;
private String password;
private Map<String, User> users = new HashMap<>(); private Map<String, String> roles = new HashMap<>();
public SuperUser(String username, String password) { this.username = username;
this.password = password;
initializeRoles();
}
private void initializeRoles() { roles.put("admin", "Administrator"); roles.put("manager", "Manager");
// Add more roles as needed
}
public String getUsername() { return username;
}

   
         public String getPassword() { return password;
}
public void addUser(String username, String password, String role) { users.put(username, new User(username, password, role));
}
public void removeUser(String username) { users.remove(username);
}
public void listUsers() { System.out.println("User List:"); for (User user : users.values()) {
System.out.println("Username: " + user.getUsername()); System.out.println("Role: " + user.getRole()); System.out.println();
} }
public void listRoles() {
System.out.println("Roles List:");
for (Map.Entry<String, String> entry : roles.entrySet()) {

   
         System.out.println("Role Name: " + entry.getKey()); System.out.println("Description: " + entry.getValue()); System.out.println();
} }
}
public class SuperUserControlUserAndRoleSystem { public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Create a super user
SuperUser superUser = new SuperUser("superuser", "super123");
// Simulate login System.out.print("Username: ");
String usernameInput = scanner.nextLine(); System.out.print("Password: ");
String passwordInput = scanner.nextLine();
if (superUser.getUsername().equals(usernameInput) && superUser.getPassword().equals(passwordInput)) {
System.out.println("Logged in as Super User"); System.out.println();

   
         // Super User Control Over User and Role while (true) {
System.out.println("1. Add User"); System.out.println("2. Remove User"); System.out.println("3. List Users"); System.out.println("4. List Roles"); System.out.println("5. Exit"); System.out.print("Enter your choice: "); int choice = scanner.nextInt();
scanner.nextLine(); // Consume the newline
switch (choice) { case 1:
System.out.print("Enter Username: ");
String newUser = scanner.nextLine(); System.out.print("Enter Password: ");
String newPassword = scanner.nextLine(); System.out.print("Enter Role (admin/manager, etc.): "); String newRole = scanner.nextLine(); superUser.addUser(newUser, newPassword, newRole); break;
case 2:
System.out.print("Enter Username to Remove: "); String userToRemove = scanner.nextLine();
   
superUser.removeUser(userToRemove);
break; case 3:
superUser.listUsers();
break; case 4:
superUser.listRoles();
break; case 5:
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