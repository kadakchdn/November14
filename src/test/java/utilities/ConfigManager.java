package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager 
{
	private static Properties properties = new Properties();
    private static final String CONFIG_PATH = "./src/test/resources/config.properties";


    // Load properties
    public static void loadProperties() throws IOException 
    {
//        try (FileInputStream fis = new FileInputStream(CONFIG_PATH)) 
//        {
//            properties.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
        FileInputStream fis = new FileInputStream(CONFIG_PATH);
        properties.load(fis);
        
    }

    // Get property value
    public static String getProperty(String key) throws IOException 
    {
        loadProperties();
        return properties.getProperty(key);
    }

    // Set property and save
    public static void setProperty(String key, String value) throws IOException 
    {
            FileOutputStream fos = new FileOutputStream(CONFIG_PATH);
            properties.setProperty(key, value);
            properties.store(fos, "Updated properties");
            
       
    }

	

}
