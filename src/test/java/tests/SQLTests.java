package tests;

import aquality.selenium.browser.AqualityServices;
import helper.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import requests.Requests;
import response.Response;
import utils.*;

public class SQLTests extends BaseTest {

    @Test
    public void test() {
        SoftAssert softAssert = new SoftAssert();

        Response.responseMinWorkingTime(Requests.selectMinWorkingTime());

        Response.responseUniqueTestsNumber(Requests.selectUniqueTestsNumber());

        Response.responseProjectTests(Requests.selectProjectTests());

        Response.responseSelectTestsNumber(Requests.selectTestsNumber());
        AqualityServices.getLogger().info("Check the number of browsers.");
        softAssert.assertEquals(
                ScenarioContext.getInstance().get("number0"),
                256,
                "Invalid number of browsers."
        );
        AqualityServices.getLogger().info("Check the number of browsers.");
        softAssert.assertEquals(
                ScenarioContext.getInstance().get("number1"),
                89,
                "Invalid number of browsers."
        );
        softAssert.assertAll();
    }
}