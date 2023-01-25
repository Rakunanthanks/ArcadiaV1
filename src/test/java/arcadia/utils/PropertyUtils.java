package arcadia.utils;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
public class PropertyUtils {
    public static Properties propertyLoader(String filePath) {
        Properties properties = new Properties();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(URLDecoder.decode(filePath, StandardCharsets.UTF_8.toString())));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("failed to load properties file "+ filePath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties file not found at " + filePath);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("Incorrect file path " + filePath);
        }
        return properties;
    }
    public static String getAbsolutePathOfFile(String fileName) {
        URL absolutePath = PropertyUtils.class.getClassLoader().getResource(fileName);
        String newAbsolutePath=absolutePath.getPath();
        return String.valueOf(newAbsolutePath);
    }
}
