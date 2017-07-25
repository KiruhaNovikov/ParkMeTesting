import java.util.Properties;


public final class Config {
    private static final Properties properties = new Properties();


    public static void loadProperties(String propertiesFile){
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            properties.load(loader.getResourceAsStream(propertiesFile));
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static String getSetting(String key) {
        return properties.getProperty(key);
    }
}
