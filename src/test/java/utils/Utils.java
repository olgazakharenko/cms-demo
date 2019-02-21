package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Document;

import java.io.*;
import java.util.Properties;

public class Utils {

    //Create Document object with test data from json file
    public static Document createDocumentFromFile() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Document document = objectMapper.readValue(new File("./src/test/resources/document-test-data.json"), Document.class);

        return document;
    }

    public static Properties loadProperties() throws IOException {

        InputStream inputStream = null;

        Properties properties = new Properties();
        try {

            String propertiesFile = "project.properties";

            inputStream = Utils.class.getClassLoader().getResourceAsStream(propertiesFile);

            if (inputStream != null) {

                properties.load(inputStream);

            } else {

                throw new FileNotFoundException("property file '" + propertiesFile + "' not found ");
            }

        } catch (Exception e) {

            System.out.println("Exception: " + e);

        } finally {

            inputStream.close();
        }

        return properties;
    }

}
