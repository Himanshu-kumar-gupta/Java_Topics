final class DbConfigSingleton {

    private final String hostName;
    private final String dbName;

    // Eagerly created singleton instance
    private static final DbConfigSingleton instance = new DbConfigSingleton();

    // Private constructor to prevent external instantiation
    private DbConfigSingleton() {
        this.hostName = "dbhost.example.com";
        this.dbName = "MyDatabase";
    }

    // Public method to return the singleton instance
    public static DbConfigSingleton getInstance() {
        return instance;
    }

    // Getters
    public String getHostName() {
        return hostName;
    }

    public String getDbName() {
        return dbName;
    }
}

public class SingletonUse2 {
    public static void main(String[] args) {
        // Access singleton instance
        DbConfigSingleton config = DbConfigSingleton.getInstance();

        // Use its data
        System.out.println("Database Host: " + config.getHostName());
        System.out.println("Database Name: " + config.getDbName());
    }
}
