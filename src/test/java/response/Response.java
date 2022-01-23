package response;

import aquality.selenium.browser.AqualityServices;
import models.Project;
import models.TestTime;
import models.TestsNumber;
import org.testng.Assert;
import utils.ScenarioContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Response {
    public static void responseMinWorkingTime(ResultSet rows) {
        AqualityServices.getLogger().info("Print 'select' answer.");
        TestTime testTime = new TestTime();
        try {
            while (rows.next()) {
                testTime.setProjectName(rows.getString("project.name"));
                testTime.setTestName(rows.getString("test.name"));
                testTime.setMinWorkingTime(rows.getInt("(test.end_time) - (test.start_time)"));
                AqualityServices.getLogger().info(testTime.toString());
            }
        } catch (SQLException throwables) {
            Assert.fail("Exception");
        }
    }

    public static void responseUniqueTestsNumber(ResultSet rows) {
        AqualityServices.getLogger().info("Print 'select' answer.");
        TestsNumber tN = new TestsNumber();
        try {
            while (rows.next()) {
                tN.setTest(rows.getString("project.name"));
                tN.setCount(rows.getInt("count(distinct(test.name))"));
                AqualityServices.getLogger().info(tN.toString());
            }
        } catch (SQLException throwables) {
            Assert.fail("Exception");
        }
    }

    public static void responseProjectTests(ResultSet rows) {
        AqualityServices.getLogger().info("Print 'select' answer.");
        Project project = new Project();
        try {
            while (rows.next()) {
                project.setProjectName(rows.getString("project.name"));
                project.setTestName(rows.getString("test.name"));
                project.setStartTime(rows.getString("start_time"));
                AqualityServices.getLogger().info(project.toString());
            }
        } catch (SQLException throwables) {
            Assert.fail("Exception");
        }
    }

    public static void responseSelectTestsNumber(ResultSet rows) {
        AqualityServices.getLogger().info("Print 'select' answer.");
        try {
            for (int i = 0; rows.next(); i++) {
                int count = rows.getInt("COUNT(browser)");
                ScenarioContext.getInstance().put("number" + i, count);
                AqualityServices.getLogger().info("|" + count + "|");
            }
        } catch (SQLException throwables) {
            Assert.fail("Exception");
        }
    }
}