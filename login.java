import java.util.Collections;
import java.util.Set;

class User {
    private String username;
    private String password;
    private Set<String> roles;
    private String storeName; // Add a new attribute for the store name

    public User(String username, String password, Set<String> roles, String storeName) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.storeName = storeName;
    }

    public String getStoreName() {
        return this.storeName;
    }

    // Constructors, getters, setters, and other methods
}

public class MainApplication {
    public static void main(String[] args) {
        RoleBasedAuthentication auth = new RoleBasedAuthentication();
        // Create users with roles and store names
        User admin = new User("admin", "admin123", Collections.singleton("admin"), "");
        User manager = new User("manager", "manager123", Collections.singleton("manager"), "");
        User store6 = new User("store6", "store6123", Collections.singleton("store"), "Store 6");

        auth.addUser(admin);
        auth.addUser(manager);
        auth.addUser(store6);

        // Simulate login as "Store 6"
        User loggedInUser = auth.login("store6", "store6123");
        if (loggedInUser != null) {
            String storeName = loggedInUser.getStoreName();
            if (!storeName.isEmpty()) {
                System.out.println("Logged in as " + storeName); // Implement store-specific actions for "Store 6"
            } else {
                System.out.println("Invalid store user.");
            }
        } else {
            System.out.println("Authentication failed.");
        }
    }
}

