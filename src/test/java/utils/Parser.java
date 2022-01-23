package utils;

import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {
    public static String parseSettingsWithTwoParameters(String key, String user, String password) {
        JSONParser parser = new JSONParser();
        String value = null;
        try(FileReader reader = new FileReader("./src/test/resources/settings.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            value  = MessageFormat.format((String)jsonObject.get(key), user, password);
        } catch (IOException | ParseException | NullPointerException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String parseQueriesWithZeroParameters(String key) {
        JSONParser parser = new JSONParser();
        String value = null;
        try(FileReader reader = new FileReader("./src/test/resources/queries.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            value  =  (String)jsonObject.get(key);
        } catch (IOException | ParseException | NullPointerException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String parseQueriesWithOneParameter(String key, String testData) {
        JSONParser parser = new JSONParser();
        String value = null;
        try(FileReader reader = new FileReader("./src/test/resources/queries.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            value  =  MessageFormat.format((String)jsonObject.get(key),testData) ;
        } catch (IOException | ParseException | NullPointerException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String parseQueriesWithTwoParameters(String key, String testData1, String testData2) {
        JSONParser parser = new JSONParser();
        String value = null;
        try(FileReader reader = new FileReader("./src/test/resources/queries.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            value  =  MessageFormat.format((String)jsonObject.get(key),testData1, testData2) ;
        } catch (IOException | ParseException | NullPointerException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String parseTestData(String key) {
        JSONParser parser = new JSONParser();
        String value = null;
        try(FileReader reader = new FileReader("./src/test/resources/testData.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            value  = (String) jsonObject.get(key);
        } catch (IOException | ParseException | NullPointerException e) {
            e.printStackTrace();
        }
        return value;
    }
}