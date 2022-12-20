package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    public static final String URL;
    public static final String BASE_URL;
    public static final String DB_USERNAME;
    public static final String DB_PASSWORD;
    public static final String DB_URL;
    public static final String LIBRARIAN_EMAIL;
    public static final String LIBRARIAN_PASSWORD;
    public static final String STUDENT_EMAIL;
    public static final String STUDENT_PASSWORD;

    public static Properties properties;


    static {

        String environment = System.getProperty("environment") != null ? environment = System.getProperty("environment") : ConfigurationReader.get("environment");
        //String environment = ConfigurationReader.get("environment");

        try {

            String path = System.getProperty("user.dir") + "/src/test/resources/Environments/" + environment + ".properties";

            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        URL = properties.getProperty("url");
        BASE_URL = properties.getProperty("base_url");
        DB_USERNAME = properties.getProperty("dbUsername");
        DB_PASSWORD = properties.getProperty("dbPassword");
        DB_URL = properties.getProperty("dbUrl");
        LIBRARIAN_EMAIL = properties.getProperty("librarian_email");
        LIBRARIAN_PASSWORD = properties.getProperty("librarian_password");
        STUDENT_EMAIL = properties.getProperty("student_email");
        STUDENT_PASSWORD = properties.getProperty("student_password");


    }

}

