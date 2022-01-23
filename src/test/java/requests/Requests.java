package requests;

import aquality.selenium.browser.AqualityServices;
import utils.DBUtils;
import utils.Parser;

import java.sql.ResultSet;

public class Requests {
    public static ResultSet selectTestsNumber() {
        String query = Parser.parseQueriesWithTwoParameters("selectBrowsers", Parser.parseTestData("chrome"), Parser.parseTestData("firefox"));
        AqualityServices.getLogger().info(String.format("Send '%s' request.", query));
        DBUtils.close();
        return DBUtils.select(query);
    }

    public static ResultSet selectProjectTests() {
        String query = Parser.parseQueriesWithOneParameter("selectTestsNumber", Parser.parseTestData("date"));
        AqualityServices.getLogger().info(String.format("Send '%s' request.", query));
        DBUtils.close();
        return DBUtils.select(query);
    }

    public static ResultSet selectUniqueTestsNumber() {
        String query = Parser.parseQueriesWithZeroParameters("selectUniqueTests");
        AqualityServices.getLogger().info(String.format("Send '%s' request.", query));
        DBUtils.close();
        return DBUtils.select(query);
    }

    public static ResultSet selectMinWorkingTime() {
        String query = Parser.parseQueriesWithZeroParameters("selectMinWorkingTime");
        AqualityServices.getLogger().info(String.format("Send '%s' request.", query));
        DBUtils.close();
        return DBUtils.select(query);
    }
}