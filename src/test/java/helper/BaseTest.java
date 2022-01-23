package helper;

import org.testng.annotations.AfterMethod;
import utils.ScenarioContext;

public class BaseTest {

    @AfterMethod
    public void afterTest() {
        if (ScenarioContext.getInstance() != null) {
            ScenarioContext.clear();
        }
    }
}