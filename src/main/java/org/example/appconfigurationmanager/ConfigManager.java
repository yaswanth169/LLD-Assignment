package org.example.appconfigurationmanager;

public class ConfigManager {
//    Requirements :
//            1. Read configs
//            2. Write configs
//            3. Only one instance should exist

//    Example:
//    DB_URL = localhost
//    API_KEY = xyz123

//    Any part of the application should be able to access the same configuration values.
//
//    ## Initial Approach
//
//    My first thought was to create a normal class.
//
//    class ConfigManager {
//
//        private Map<String, String> configs =
//                new HashMap<>();
//
//        public void put(String key, String value) {
//            configs.put(key, value);
//        }
//
//        public String get(String key) {
//            return configs.get(key);
//        }
//    }
//
//
//    ConfigManager c1 = new ConfigManager();
//    ConfigManager c2 = new ConfigManager();
//
//    ## Problems with this Approach
//
//    Multiple objects can be created.
//
//    ConfigManager c1 = new ConfigManager();
//    ConfigManager c2 = new ConfigManager();
//
//    If a value is stored using `c1`, it may not be available in `c2` because both are different objects.
//
//    c1.put("DB_URL", "localhost");

//    c2.get("DB_URL");
//    This can lead to inconsistent configuration data across the application.
//
//    ## Observation
//    The main requirement says that only one configuration manager should exist.
//    The configuration data should be shared across the entire application.

//    ## Solution
//    I used the Singleton Pattern.
//    The constructor is made private so that objects cannot be created from outside the class.
//    A single instance is created and accessed using a static method.

//    ConfigManager config =
//            ConfigManager.getInstance();


//    Now every part of the application uses the same object.

//    ConfigManager c1 =
//            ConfigManager.getInstance();

//    ConfigManager c2 =
//            ConfigManager.getInstance();

//
//    Both references point to the same instance.

//    1. Singleton Pattern.
//    2. Because the requirement clearly states that only one configuration manager should exist. Singleton ensures a single shared instance and provides a common access point throughout the application.
//    3.
//            1. Create a normal class and manually pass the same object everywhere.
//            2. Use Dependency Injection frameworks like Spring, where beans are singleton by default.
//            3. Use Enum Singleton in Java for a thread-safe implementation.

}
