package main.java.fr.ynov.remind.factory;


import main.java.fr.ynov.remind.domain.Element;
import main.java.fr.ynov.remind.domain.PhoneElement;
import main.java.fr.ynov.remind.domain.TextElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class JsonHandler {
    private static final String filePath = "src/main/resources/elements.txt";

    /**
     * This method loads data from a JSON file and populates the ElementsFactory with the elements.
     * It creates a new file if it doesn't exist.
     *
     * @param elementsFactory The factory that creates and manages the different elements.
     */
    public static void loadDataFromJSon(ElementsFactory elementsFactory) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found, creating a new one.");
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(filePath);
            // Parse the JSON file
            JSONArray jsonElements = (JSONArray) jsonParser.parse(reader);

            for (Object jsonElement : jsonElements) {
                // Parse each JSON object
                JSONObject jsonObject = (JSONObject) jsonElement;

                String title = (String) jsonObject.get("title");
                String tag = (String) jsonObject.get("tag");
                // Convert the date from milliseconds to a Calendar object
                long timeInMillis = (long) jsonObject.get("date");
                Calendar date = Calendar.getInstance();
                date.setTimeInMillis(timeInMillis);

                // Check the type of the element and create the corresponding object
                if ("TEXT".equals(jsonObject.get("type"))) {
                    String description = (String) jsonObject.get("description");
                    elementsFactory.addElement(new TextElement(title, date, description, ElementsFactory.stringToTag(tag)));
                } else if ("PHONE".equals(jsonObject.get("type"))) {
                    String contactName = (String) jsonObject.get("contactName");
                    String phoneNumber = (String) jsonObject.get("phoneNumber");
                    elementsFactory.addElement(new PhoneElement(title, date, phoneNumber, contactName, ElementsFactory.stringToTag(tag)));
                }
            }
            reader.close();
        } catch (IOException | ParseException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method saves the elements from the ElementsFactory to a JSON file.
     * @param elementsFactory The factory that creates and manages the different elements.
     * @throws Exception
     */
    public static void saveDataToJSon(ElementsFactory elementsFactory) throws Exception {
        JSONArray jsonElements = new JSONArray();

        // Check if the elementsFactory is not empty
        if (!elementsFactory.getAllElements().isEmpty()) {
            for (Element elementIterator : elementsFactory.getAllElements().values()) {
                JSONObject jsonElement = getJsonObject(elementIterator);

                jsonElements.add(jsonElement);
            }
        } else {
            jsonElements.clear();
        }

        // Write the JSON array to a file
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonElements.toJSONString());
            System.out.println("Data successfully written in :" + filePath);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    /**
     * This method is used to create a JSON object from one of the elements.
     * @param elementIterator
     * @return JSONObject
     */
    private static JSONObject getJsonObject(Element elementIterator) {
        JSONObject jsonElement = new JSONObject();
        jsonElement.put("title", elementIterator.getName());
        jsonElement.put("tag", elementIterator.getTag().name());
        jsonElement.put("date", elementIterator.getDate().getTimeInMillis());

        // Check the type of the element and add the corresponding properties
        if (elementIterator instanceof TextElement) {
            jsonElement.put("type", "TEXT");
            jsonElement.put("description", ((TextElement) elementIterator).getDescription());
        } else if (elementIterator instanceof PhoneElement) {
            jsonElement.put("type", "PHONE");
            jsonElement.put("contactName", ((PhoneElement) elementIterator).getContactName());
            jsonElement.put("phoneNumber", ((PhoneElement) elementIterator).getPhoneNumber());
        }
        return jsonElement;
    }
}
