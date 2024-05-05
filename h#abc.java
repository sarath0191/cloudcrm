// Role-Based Login class User {
    private String username; private String password; private Set<String> roles;
    // Constructors, getters, setters, and other methods }
    class RoleBasedAuthentication {
    private Map<String, User> users = new HashMap<>();
    public void addUser(User user) { users.put(user.getUsername(), user);
    }
    public User login(String username, String password) {
    User user = users.get(username);
    if (user != null && user.getPassword().equals(password)) {
    return user; }
    return null; }

             // Implement role-based access control here }
    // Session Management class SessionManager {
    private static Map<String, User> activeSessions = new HashMap<>();
    public static void createSession(String sessionId, User user) { activeSessions.put(sessionId, user);
    }
    public static void endSession(String sessionId) { activeSessions.remove(sessionId);
    }
    public static User getUserBySessionId(String sessionId) { return activeSessions.get(sessionId);
    } }
    // Role-Based Login and Session Management Integration public class MainApplication {
    public static void main(String[] args) {
    RoleBasedAuthentication auth = new RoleBasedAuthentication();
       
             // Create users with roles
    User admin = new User("admin", "admin123", Collections.singleton("admin"));
    User manager = new User("manager", "manager123", Collections.singleton("manager"));
    auth.addUser(admin); auth.addUser(manager);
    // Simulate login
    User loggedInUser = auth.login("admin", "admin123");
    if (loggedInUser != null) {
    // Create a session for the logged-in user
    String sessionId = UUID.randomUUID().toString(); SessionManager.createSession(sessionId, loggedInUser);
    // Access user roles from the session
    User userInSession = SessionManager.getUserBySessionId(sessionId);
    if (userInSession != null) {
    Set<String> roles = userInSession.getRoles(); if (roles.contains("admin")) {
    System.out.println("Logged in as admin.");
    // Implement admin-specific actions } else if (roles.contains("manager")) {
    System.out.println("Logged in as manager.");
       
    // Implement manager-specific actions } else {
    System.out.println("Unknown role."); }
    } else {
    System.out.println("Session expired or invalid.");
    }
    } else {
    System.out.println("Authentication failed."); }
    } }