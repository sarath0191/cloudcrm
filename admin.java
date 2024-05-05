import java.util.HashMap; import java.util.Map;
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
public String getRole() { return role;

         } }
public class UserAuthenticationSystem {
private Map<String, User> userDatabase = new HashMap<>();
public UserAuthenticationSystem() {
// Initialize the user database with some users
userDatabase.put("admin", new User("admin", "admin123", "administrator")); userDatabase.put("superuser", new User("superuser", "super123", "superuser"));
}
public User login(String username, String password) { User user = userDatabase.get(username);
if (user != null && user.getPassword().equals(password)) { return user;
}
return null; // Authentication failed }
public static void main(String[] args) {
UserAuthenticationSystem authSystem = new UserAuthenticationSystem();
   
// Simulate login attempts
User loggedInUser = authSystem.login("admin", "admin123");
if (loggedInUser != null && loggedInUser.getRole().equals("administrator")) {
System.out.println("Logged in as Administrator"); } else {
System.out.println("Authentication failed."); }
loggedInUser = authSystem.login("superuser", "super123");
if (loggedInUser != null && loggedInUser.getRole().equals("superuser")) {
System.out.println("Logged in as Super User"); } else {
System.out.println("Authentication failed."); }
} }